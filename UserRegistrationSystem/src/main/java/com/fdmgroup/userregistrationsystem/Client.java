package com.fdmgroup.userregistrationsystem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class Client is used to register new client.
 * @author ABMKSHYAM005
 *
 */
public class Client {
	
private static final Logger LOGGER;
	
	static {
		LOGGER = LogManager.getLogger();
		LOGGER.trace(":: class loaded.");
	}
/**
 * Main method in client class.
 * @param args
 */
	public static void main(String[] args) {
		
		LOGGER.trace(" Registering new user.");
		/**
		 * Constructor for registration controller is called and new user is added.
		 */
		RegistrationController newUser = new RegistrationController();
		
		newUser.registerNewUser("FinalTestFromClient","abcd","SE");

	}

}
