package com.aeroBlasters.flightManagementSystem.bean;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;

//import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;


@Entity
public class flightUser extends User {

	
	@Id
	private String username;
	private String password;
	private String type;

	public flightUser() {
		super("abc","pqr",new ArrayList<>());
		// TODO Auto-generated constructor stub
	}
	
	public flightUser(String username, String password, java.util.Collection<? extends GrantedAuthority> authorities,String username2, String password2,String type2 ) {
		super(username,password,authorities);
		this.username = username2;
		this.password = password2;
		this.type = type2;

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "flightUser [username=" + username + ", password=" + password + ", type=" + type + "]";
	}	
}
