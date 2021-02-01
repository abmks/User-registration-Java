package com.fdmgroup.userregistrationsystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 * FileReadCommand class implementing ReadCommand interface. This class reads the user data .txt file and 
 * returns the user if it already exists otherwise returns null.
 * @author ABMKSHYAM005
 *
 */
public class FileReadCommand implements ReadCommand {
	
	private static final Logger LOGGER;
	
	static {
		LOGGER = LogManager.getLogger();
		LOGGER.trace(":: class loaded.");
	}
	
	private User user;
/**
 * FileReadCommand constructor when called creates a new FileReadCommand and creates a new user.
 */
	public FileReadCommand() {
		super();
		user = new User();
		
	}
/**
 * FileReadCommand constructor with user passed, when called creates a new FileReadCommand and
 * assigns user to this.user. Used for testing.
 * @param user is created inside the test case.
 */
	public FileReadCommand(User user) {
		super();
		this.user = user;
	}

	String source = "UserData.txt";
	/**
	 * readUser method takes in a username and check in the userdata.txt file.
	 */
	@Override
	public User readUser(String username) {

		LOGGER.trace("readUser method called.");
		
		File fromFile = new File(source);

		try (FileReader fileReader = new FileReader(fromFile);
				BufferedReader bufferedReader = new BufferedReader(fileReader);) {
			LOGGER.trace("reading User from file to check username.");
			String currentLine = bufferedReader.readLine();
			while (currentLine != null) {
				String[] splits = currentLine.split(";");
				String splits1 = splits[0];
				if (splits1.equals(username)) {
					user.setUsername(splits1);
					user.setPassword(splits[1]);
					user.setRole(splits[2]);
					LOGGER.trace("not a unique username.");
					return user;
				}
					currentLine = bufferedReader.readLine();
			}
		} catch (FileNotFoundException e) {
			LOGGER.error("#validate:: exception thrown..." , e);
			e.printStackTrace();
		} catch (IOException e) {
			LOGGER.error("#validate:: exception thrown..." , e);
			e.printStackTrace();
		}
		LOGGER.trace("a unique username.");
		return null;

	}

}
