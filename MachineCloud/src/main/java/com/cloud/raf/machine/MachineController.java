package com.cloud.raf.machine;

import java.util.ArrayList;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/machine")
public class MachineController {


	@Autowired
	private MachineService service;
			
	
	
	@RequestMapping("/start/{uid}")
	public ResponseEntity<?> start(@PathVariable("uid") String uid) {
		return service.start(uid);
	} 
	
	@RequestMapping("/stop/{uid}")
	public ResponseEntity<?> stop(@PathVariable("uid") String uid) {	
		return service.stop(uid);
		
	}
	
	
	@GetMapping
	public ArrayList<MachineModel> getMachines(){
		return service.getMachines();
	}
	
	
	
	
	@RequestMapping("/delete/{uid}")
	public ResponseEntity<?> destroy(@PathVariable("uid") String uid) {
		
		 return service.deleteMachine(uid);
	
	}
	
	
	
	
	
	@RequestMapping("/create")
	@PostMapping
	public ResponseEntity<?> create() {
	
		
		service.createMachine();
		return ResponseEntity.ok("OK");
	}
	
	

}
