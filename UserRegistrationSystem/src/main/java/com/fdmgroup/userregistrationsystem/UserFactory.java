package com.fdmgroup.userregistrationsystem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 * Class userfactory creates a user whenever a new object is created.
 * @author ABMKSHYAM005
 *
 */
public class UserFactory {

	private static final Logger LOGGER;
	User user;

	static {
		LOGGER = LogManager.getLogger();
		LOGGER.trace(":: class loaded.");
	}
/**
 * Constructor for Userfactory and creates a new user object as well.
 */
	public UserFactory() {
		super();
		user = new User();
		LOGGER.trace(" constrctor called.");
	}
/**
 * Constructor for testing, user is passed from the test case and user is assigned to the local variable.
 * @param user
 */
	public UserFactory(User user) {
		super();
		this.user = user;
		LOGGER.trace(" testing constrctor called.");
	}
/**
 * createuser method returns a user when called.
 * @return a new user object.
 */
	public User createUser() {
		
		LOGGER.trace(" new user created.");
		return user;

	}

}
