package com.fdmgroup.userregistrationsystem;
/**
 * Interface ReadCommand incudes and abstract method for readUser
 * @author ABMKSHYAM005
 *
 */
public interface ReadCommand{
	/**
	 * Abstract method readUser takes in Username and returns user.
	 * @param username
	 * @return
	 */
	public User readUser(String username);
	
}
