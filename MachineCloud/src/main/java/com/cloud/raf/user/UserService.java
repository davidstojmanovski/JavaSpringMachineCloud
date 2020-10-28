package com.cloud.raf.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserDao dao;
	
	
	public void createUser(UserModel model) {
		
		UserEntity user=new UserEntity();
		user.setFirstName(model.getFirstName());
		user.setLastName(model.getLastName());
		user.setUsername(model.getUsername());
		user.setPassword(model.getPassword());
		dao.save(user);
	}
	
	
	
	
	
	
	
	
}
