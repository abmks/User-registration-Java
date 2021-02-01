package com.fdmgroup.UserRegistrationSystemTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fdmgroup.userregistrationsystem.User;

class UserTest {

	private User classUnderTest;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetUsername() {

		// arrange
		classUnderTest = new User();
		classUnderTest.setUsername("abcd");
		String expected = "abcd";

		// act
		String actual = classUnderTest.getUsername();

		// assert
		assertEquals(expected, actual);

	}

	@Test
	void testGetPassword() {

		// arrange
		classUnderTest = new User();
		classUnderTest.setPassword("abcd");
		String expected = "abcd";

		// act
		String actual = classUnderTest.getPassword();

		// assert
		assertEquals(expected, actual);

	}
	
	@Test
	void testGetRole() {

		// arrange
		classUnderTest = new User();
		classUnderTest.setRole("abcd");
		String expected = "abcd";

		// act
		String actual = classUnderTest.getRole();

		// assert
		assertEquals(expected, actual);

	}

}
