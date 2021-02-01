package com.fdmgroup.userregistrationsystem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 * Class implements writeCommand interface and writes the user to the userdata.txt file.
 * @author ABMKSHYAM005
 *
 */
public class FileWriteCommand implements WriteCommand {

	private static final Logger LOGGER;

	static {
		LOGGER = LogManager.getLogger();
		LOGGER.trace(":: class loaded.");
	}

	final String destination = "UserData.txt";
	String username;
	String password;
	String role;
	
	File toFile = new File(destination);

	FileWriter fileWriter;
	BufferedWriter bufferedWriter;
	//File toFile = new File(destination);*/
/**
 * Constructor for FilewriteCommand.
 */
	public FileWriteCommand() {
		super();
	}
/**
 * writeUser when called write the user to the userdata.txt file and takes in the user as parameter.
 */
	@Override
	public void writeUser(User user) {

		LOGGER.trace(" Write User method called.");

		username = user.getUsername();
		password = user.getPassword();
		role = user.getRole();
		
		try (FileWriter fileWriter  = new FileWriter(toFile, true);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);)  {
			LOGGER.trace(" writing User to file.");
			bufferedWriter.write(username + ";" + password + ";" + role + ";");
			bufferedWriter.newLine();
			LOGGER.trace(" writing User to file completed.");
		} catch (IOException e) {
			LOGGER.error("#validate:: exception thrown...", e);
			e.printStackTrace();
		}

	}

}
