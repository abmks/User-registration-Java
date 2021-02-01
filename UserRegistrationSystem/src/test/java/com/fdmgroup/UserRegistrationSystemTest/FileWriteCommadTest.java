	package com.fdmgroup.UserRegistrationSystemTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
import com.fdmgroup.userregistrationsystem.User;

class FileWriteCommadTest {
	
	private FileWriteCommand classUnderTest;
	
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
		String source = "UserData.txt";
		File fromFile = new File(source);

		classUnderTest = new FileWriteCommand();
		mockUser = new User();
		
		mockUser.setUsername("test");
		mockUser.setPassword("test");
		mockUser.setRole("test");
		
		String expected = "test;test;test;";
		String actual = null;
		
		//Act
		
		classUnderTest.writeUser(mockUser);
		
		try (FileReader fileReader = new FileReader(fromFile);
				BufferedReader bufferedReader = new BufferedReader(fileReader);) {
			String currentLine = bufferedReader.readLine();
			while(currentLine != null) {
				if (currentLine.equals(expected)) {
					actual = currentLine;					
				}
					currentLine = bufferedReader.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Assert
		
		assertEquals(expected, actual);
		
		

	}

}
