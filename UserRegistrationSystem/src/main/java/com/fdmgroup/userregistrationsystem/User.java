package com.fdmgroup.userregistrationsystem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class User {
	
	private static final Logger LOGGER;
	
	static {
		LOGGER = LogManager.getLogger();
		LOGGER.trace(":: class loaded.");
	}
	
	private String username;
	private String password;
	private String role;
	
	public String getUsername() {
		LOGGER.trace(" getUsername called.");
		return username;
	}
	public void setUsername(String username) {
		LOGGER.trace(" setUsername called.");
		this.username = username;
	}
	public String getPassword() {
		LOGGER.trace(" getPassword called.");
		return password;
	}
	public void setPassword(String password) {
		LOGGER.trace(" setPassword called.");
		this.password = password;
	}
	public String getRole() {
		LOGGER.trace(" getRole called.");
		return role;
	}
	public void setRole(String role) {
		LOGGER.trace(" setRole called.");
		this.role = role;
	}
	
	

}
