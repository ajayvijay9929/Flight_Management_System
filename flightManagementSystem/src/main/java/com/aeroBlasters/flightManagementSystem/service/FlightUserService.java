package com.aeroBlasters.flightManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aeroBlasters.flightManagementSystem.bean.flightUser;
import com.aeroBlasters.flightManagementSystem.dao.FlightUserRepository;

@Service
public class FlightUserService implements UserDetailsService {
	@Autowired
	private FlightUserRepository repository;
	private String type;		//type=usertype customer or admin
	
	//To Save user details in DB
	public void save(flightUser user) {
		repository.save(user);
	}
	
	//For different type of pages for admin and customer 
	public String  getType() {
		return type;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		flightUser users=repository.findById(username).get();
		type=users.getType();
		return users;
		
	}
	
}
