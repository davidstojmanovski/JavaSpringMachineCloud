package com.cloud.raf.machine;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.cloud.raf.user.UserDao;
import com.cloud.raf.user.UserEntity;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MachineService {
	
	@Autowired
	private MachineDao machineRep;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	
	public ResponseEntity<?> deleteMachine(String uid){
		
			MachineEntity me=machineRep.findByUid(uid).get(0);
			
			me.setActive(false);
			machineRep.save(me);
			
		return ResponseEntity.ok("OK");
	}
	
	
	
	public ArrayList<MachineModel> getMachines(){
		UserDetails userDetails=(UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ArrayList<MachineEntity> entities=machineRep.findAllByUserEntity(userDao.findByUsername(userDetails.getUsername()));
		ArrayList<MachineModel> models=new ArrayList<MachineModel>();
		
		//filtering 
		for (MachineEntity machineEntity : entities) {
			if(machineEntity.getActive()==true) {
				MachineModel model=new MachineModel();
				model.setStatus(machineEntity.getStatus());
				model.setUid(machineEntity.getUid());
				models.add(model);
			}
		}
		
		
		return models;
	}
	
	
	public ResponseEntity<?> createMachine() {
		MachineEntity ent=new MachineEntity();
		ent.setActive(true);
		ent.setStatus("STOPPED");
		
		//getting userDetails from token 
		UserDetails userDetails=(UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		ent.setUserEntity(userDao.findByUsername(userDetails.getUsername()));
		ent.setUid(UUID.randomUUID().toString());
		machineRep.save(ent);
		return ResponseEntity.ok("OK");
}
	
	
	public ResponseEntity<?> start(String uid) {
		MachineEntity me=machineRep.findByUid(uid).get(0);
		
		me.setStatus("RUNNING");
		machineRep.save(me);
		return ResponseEntity.ok("OK");
}
	
	
	public ResponseEntity<?> stop(String uid) {
		MachineEntity me=machineRep.findByUid(uid).get(0);
		me.setStatus("STOPPED");
		machineRep.save(me);
		return ResponseEntity.ok("OK");
}
	
	
	
}
