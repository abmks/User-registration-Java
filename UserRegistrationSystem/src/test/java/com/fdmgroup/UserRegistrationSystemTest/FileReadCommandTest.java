package com.fdmgroup.UserRegistrationSystemTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.fdmgroup.userregistrationsystem.FileReadCommand;
import com.fdmgroup.userregistrationsystem.User;
import com.fdmgroup.userregistrationsystem.UserFactory;

class FileReadCommandTest {
	
	private FileReadCommand classUnderTest;
	
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
	void testForFileReadCommandforExistingUsername() {
		
		//Assign
		mockUser = Mockito.spy(new User());
		classUnderTest = new FileReadCommand(mockUser);
		mockUser.setUsername("Abi5");
	
		//Act
		
		User actual = classUnderTest.readUser(mockUser.getUsername());
		
		//Assert
		
		assertEquals(mockUser, actual);
		
	}
	
	@Test
	void testForFileReadCommandforNewUsername() {
		
		//Assign
		mockUser = Mockito.spy(new User());
		classUnderTest = new FileReadCommand(mockUser);
		mockUser.setUsername("Abi11");
		User expected = null;
		
		//Act
		
		User actual = classUnderTest.readUser(mockUser.getUsername());
		
		//Assert
		
		assertEquals(expected, actual);
		
	}

}
