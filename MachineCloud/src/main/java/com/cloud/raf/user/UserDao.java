package com.cloud.raf.user;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<UserEntity, Long>  {


	UserEntity findByUsername(String username);
	
}
