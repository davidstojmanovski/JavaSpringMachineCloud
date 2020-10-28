package com.cloud.raf.machine;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.cloud.raf.user.UserEntity;

public interface MachineDao extends CrudRepository<MachineEntity, Long> {

	
	ArrayList<MachineEntity> findByUid(String uid);
	
	ArrayList<MachineEntity> findAllByUserEntity(UserEntity userEntity);
	
	
	
	
	
	
}
