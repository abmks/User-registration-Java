package com.fdmgroup.userregistrationsystem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 * Registration controller class checks whether a username is unique or not. If the username 
 * is unique user is created and written to the file. If the username is not unique, a new user name 
 * is requested.
 * @author ABMKSHYAM005
 *
 */
public class RegistrationController {

	private static final Logger LOGGER;
	private ReadCommand readCommand;
	private WriteCommand writeCommand;
	private UserFactory userFactory;
	private static User user;

	static {
		LOGGER = LogManager.getLogger();
		LOGGER.trace(":: class loaded.");
	}
	
	public static User getUser() {
		LOGGER.trace(" get user called.");
		return user;
	}
/**
 * setUser for setting the user variable.
 * @param user is passed from the calling program.
 */
	public static void setUser(User user) {
		RegistrationController.user = user;
	}
/**
 * Constructor for registration controller.
 */
	public RegistrationController() {
		super();
		readCommand = new FileReadCommand();
		userFactory = new UserFactory();
		writeCommand = new FileWriteCommand();
		LOGGER.trace(" constructor called.");
	}
/**
 * Constructor for registration controller for testing.
 * @param readCommand is passed from the calling program.
 * @param writeCommand is passed from the calling program.
 * @param userFactory is passed from the calling program.
 */
	public RegistrationController(ReadCommand readCommand, WriteCommand writeCommand, UserFactory userFactory) {
		super();
		this.readCommand = readCommand;
		this.writeCommand = writeCommand;
		this.userFactory = userFactory;
		LOGGER.trace(" constructor for testing called.");
	}

	// Test registerNewUser
	/**
	 * Method registerNewUser for creating a new user.
	 * @param username is the username for new user.
	 * @param password is the password for new user.
	 * @param role is the role of the new user.
	 */
	public void registerNewUser(String username, String password, String role) {

		LOGGER.trace(
				" register newUser called with username: " + username +
				" password: " + password + " and role: " + role);
		// test readUser
		User user1 = readCommand.readUser(username);

		if (user1 == null) {
			
			LOGGER.trace(" UserId unique and new user is created");
			// test
			user = userFactory.createUser();
			user.setUsername(username);
			user.setPassword(password);
			user.setRole(role);

			// test writeUser
			writeCommand.writeUser(user);
			System.out.println("User " + user.getUsername() + " added. ");
			
		} /*test else part*/ else {

			LOGGER.trace(" UserId is not unique and new user is not created");

			System.out.println("Username " + user1.getUsername() + " already taken, please enter a unique username. ");

		}

	}

}
