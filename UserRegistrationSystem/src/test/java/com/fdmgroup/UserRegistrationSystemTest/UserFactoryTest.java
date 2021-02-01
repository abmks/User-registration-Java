package com.fdmgroup.UserRegistrationSystemTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.fdmgroup.userregistrationsystem.ReadCommand;
import com.fdmgroup.userregistrationsystem.User;
import com.fdmgroup.userregistrationsystem.UserFactory;

class UserFactoryTest {
	
	private UserFactory classUnderTest;
	
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
	void testforCreateUser() {
		
		//Arrange
		
		classUnderTest = new UserFactory(mockUser);
		
		
		//Act
		
		User actual = classUnderTest.createUser();
		
		//Assert
		
		assertEquals(mockUser, actual);
	}

}
