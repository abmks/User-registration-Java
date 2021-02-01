package com.fdmgroup.UserRegistrationSystemTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.fdmgroup.userregistrationsystem.FileReadCommand;
import com.fdmgroup.userregistrationsystem.FileWriteCommand;
import com.fdmgroup.userregistrationsystem.ReadCommand;
import com.fdmgroup.userregistrationsystem.RegistrationController;
import com.fdmgroup.userregistrationsystem.User;
import com.fdmgroup.userregistrationsystem.UserFactory;
import com.fdmgroup.userregistrationsystem.WriteCommand;

class RegistrationControllerTest {

	private RegistrationController classUnderTest;
	
	@Mock
	private ReadCommand mockReadCommand;
	
	@Mock
	private WriteCommand mockWriteCommand;
	
	@Mock
	private UserFactory mockUserFactory;
	
	@Mock
	private User mockUser;
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testForRegisterNewUserCallingReadUser() {
		
		//arrange
		/*mockReadCommand = Mockito.spy(new FileReadCommand());
		mockWriteCommand = new FileWriteCommand();
		mockUserFactory = new UserFactory();*/
		
		when(mockUserFactory.createUser()).thenReturn(mockUser);
		classUnderTest = new RegistrationController(mockReadCommand, mockWriteCommand, mockUserFactory);
		
		String username = "abcd11";
		String password = "abcd";
		String role = "abcd";
		
		//act
		
		classUnderTest.registerNewUser(username,password,role);
		
		//assert

		verify(mockReadCommand,times(1)).readUser(username);
		
	}
	
	@Test
	void testForRegisterNewUserCallingUserFactoryForNewUser() {
		
		//arrange
		
		/*mockReadCommand = new FileReadCommand();
		mockWriteCommand = Mockito.spy(new FileWriteCommand());
		mockUserFactory = Mockito.spy(new UserFactory());*/
		
		when(mockUserFactory.createUser()).thenReturn(mockUser);
		classUnderTest = new RegistrationController(mockReadCommand, mockWriteCommand, mockUserFactory);
		
		//change username for each run
		String username = "abcd11";
		String password = "abcd";
		String role = "abcd";
			
		//act
		
		classUnderTest.registerNewUser(username,password,role);
		
		//assert
		verify(mockUserFactory,times(1)).createUser();
		verify(mockWriteCommand,times(1)).writeUser(RegistrationController.getUser());
		
	}

	@Test
	void testForRegisterNewUserCallingElseForExistingUser() {
		
		//arrange
		// username "abcd" is already added in the userdata.txt file
		String username = "abcd";
		String password = "abcd";
		String role = "abcd";
			
		mockReadCommand = Mockito.spy(new FileReadCommand());
		mockWriteCommand = new FileWriteCommand();
		mockUserFactory = Mockito.spy(new UserFactory());
		
		when(mockReadCommand.readUser(username)).thenReturn(mockUser);
		classUnderTest = new RegistrationController(mockReadCommand, mockWriteCommand, mockUserFactory);

	
		//act
		
		classUnderTest.registerNewUser(username,password,role);
		
		//assert
		verify(mockUser,times(1)).getUsername();
		
	}
}
