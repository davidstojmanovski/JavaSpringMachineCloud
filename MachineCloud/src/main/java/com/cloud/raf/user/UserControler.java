package com.cloud.raf.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserControler {

	@Autowired
	private UserService service;
	
	@RequestMapping("/create")
	public ResponseEntity<?>createEntity(@RequestBody UserModel model) {
		service.createUser(model);
		return ResponseEntity.ok("OK");
		
	}
	
	
}
