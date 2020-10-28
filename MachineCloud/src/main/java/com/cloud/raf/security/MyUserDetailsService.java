package com.cloud.raf.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cloud.raf.user.UserDao;
import com.cloud.raf.user.UserEntity;


@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserEntity user=userDao.findByUsername(username);
		
		MyUserDetails userDet=new MyUserDetails(user);
		
		return userDet;
	}
	
	
	
}
