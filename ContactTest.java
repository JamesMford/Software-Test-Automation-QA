package com.snhu;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ContactTest {
	
	@DisplayName("Expected to Successfully create a Contact with attributes")
	@Test
	void testValidContact() {
		Contact testContact = new Contact("James", "Ford", "2500 North River Road", "2075555456");
		assertTrue(testContact.getFirstName().length() <= 10);
		assertTrue(testContact.getFirstName() == "James");
		
		assertTrue(testContact.getLastName().length() <= 10);
		assertTrue(testContact.getLastName() == "Ford");
		
		assertTrue(testContact.getAddress().length() <= 30);
		assertTrue(testContact.getAddress() == "2500 North River Road");
		
		assertTrue(testContact.getNumber().length() == 10);
		assertTrue(testContact.getNumber() == "2075555456");
	}
	
	
	@DisplayName("Expected to Throw IllegalArgumentException: First name is greater than 10 characters")
	@Test
	void testInvalidContact() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("Tyrannosaurus", "Ford", "2500 North River Road", "2075555456");
		});
		assertEquals("first name must not be null, empty, or greater than 10 characters", exception.getMessage());
	}
	
	
	@DisplayName("Expected to Throw IllegalArgumentException: First name is null")
	@Test
	void testNullFirstName() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()-> {
			new Contact(null, "Ford", "2500 North River Road", "2075555456");
		});
		assertEquals("first name must not be null, empty, or greater than 10 characters", exception.getMessage());
	}
	
	
	@DisplayName("Expected to Throw IllegalArgumentException: First name is empty")
	@Test
	void testEmptyFirstName() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("", "Ford", "2500 North River Road", "2075555456");
		});
		assertEquals("first name must not be null, empty, or greater than 10 characters", exception.getMessage());
	}
	
	
	@DisplayName("Expected to Throw IllegalArgumentException: Last name is null")
	@Test
	void testNullLastName() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("James", null, "2500 North River Road", "2075555456");
		});
		assertEquals("last name must not be null, empty, or greater than 10 characters", exception.getMessage());
	}
	
	
	@DisplayName("Expected to Throw IllegalArgumentException: Phone Number is greater than 10 digits")
	@Test
	void testTooLongPhoneNumber() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("James", "Ford", "2500 North River Road", "2075555456207");
		});
		assertEquals("phone number must not be null or empty, and have 10 digits", exception.getMessage());
	}
	
	
	@DisplayName("Expected to Throw IllegalArgumentException: Phone Number is less than 10 digits")
	@Test
	void testTooShortPhoneNumber() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("James", "Ford", "2500 North River Road", "5555456");
		});
		assertEquals("phone number must not be null or empty, and have 10 digits", exception.getMessage());
	}
	
	
	@DisplayName("Expected to Throw IllegalArgumentException: Address is Too Long")
	@Test
	void testTooLongAddress() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("James", "Ford", "25000 SuperCalifragilisticExpialodocious Lane, Manchester, New Hampshire", "2075555456207");
		});
		assertEquals("address must not be null, empty, or greater than 30 characters", exception.getMessage());
	}
	
	
	@DisplayName("Expected to Successfully set a first name")
	@Test
	void testSetFirstNameMethod() {
		Contact testContact = new Contact("James", "Ford", "2500 North River Road", "2075555456");
		assertTrue(testContact.getFirstName().equals("James"));
		testContact.setFirstName("Henry");
		assertTrue(testContact.getFirstName().equals("Henry"));
	}
	
	
	@DisplayName("Expected to Successfully set a last name")
	@Test
	void testSetLastNameMethod() {
		Contact testContact = new Contact("James", "Ford", "2500 North River Road", "2075555456");
		assertTrue(testContact.getLastName().equals("Ford"));
		testContact.setLastName("Cavill");
		assertTrue(testContact.getLastName().equals("Cavill"));
	}
	
	
	@DisplayName("Expected to Successfully set a full name")
	@Test
	void testSetFullNameMethod() {
		Contact testContact = new Contact("James", "Ford", "2500 North River Road", "2075555456");
		assertTrue(testContact.getName().equals("James Ford"));
		testContact.setName("Henry", "Cavill");
		assertTrue(testContact.getName().equals("Henry Cavill"));
	}
	
	
	@DisplayName("Expected to Successfully set an address")
	@Test
	void testSetAddressMethod() {
		Contact testContact = new Contact("James", "Ford", "2500 North River Road", "2075555456");
		assertTrue(testContact.getAddress().equals("2500 North River Road"));
		testContact.setAddress("128 Orange Street");
		assertTrue(testContact.getAddress().equals("128 Orange Street"));
	}
	
	
	@DisplayName("Expected to Successfully return a full contact name")
	@Test
	void testGetNameMethod() {
		Contact testContact = new Contact("James", "Ford", "2500 North River Road", "2075555456");
		assertTrue(testContact.getName().equals("James Ford"));
	}
	
	
	@DisplayName("Expected to Successfully return a contact address")
	@Test
	void testGetaddress() {
		Contact testContact = new Contact("James", "Ford", "2500 North River Road", "2075555456");
		assertTrue(testContact.getAddress().equals("2500 North River Road"));
	}
	
	
	@DisplayName("Expected to Successfully return a phone number")
	@Test
	void testGetNumberMethod() {
		Contact testContact = new Contact("James", "Ford", "2500 North River Road", "2075555456");
		assertTrue(testContact.getNumber().equals("2075555456"));
	}
	
	
	@DisplayName("Expected to Successfully return a phone number")
	@Test
	void testSetNumberMethod() {
		Contact testContact = new Contact("James", "Ford", "2500 North River Road", "2075555456");
		assertTrue(testContact.getNumber().equals("2075555456"));
		testContact.setNumber("3125553436");
		assertTrue(testContact.getNumber().equals("3125553436"));
	}
	
	
	@DisplayName("Expected to Throw IllegalArgumentException: First name is empty")
	@Test
	void testSetFirstNameEmpty() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()-> {
			Contact testContact = new Contact("James", "Ford", "2500 North River Road", "2075555456");
			testContact.setFirstName("");
		});
		assertEquals("first name must not be null, empty, or greater than 10 characters", exception.getMessage());
		
	}
	
	
	@DisplayName("Expected to Throw IllegalArgumentException: First name is null")
	@Test
	void testSetFirstNameNull() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()-> {
			Contact testContact = new Contact("James", "Ford", "2500 North River Road", "2075555456");
			testContact.setFirstName(null);
		});
		assertEquals("first name must not be null, empty, or greater than 10 characters", exception.getMessage());
	}
	
	
	@DisplayName("Expected to Throw IllegalArgumentException: Last name is null")
	@Test
	void testSetLastNameNull() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()-> {
			Contact testContact = new Contact("James", "Ford", "2500 North River Road", "2075555456");
			testContact.setLastName(null);
		});
		assertEquals("last name must not be null, empty, or greater than 10 characters", exception.getMessage());
	}
	
	
	@DisplayName("Expected to Throw IllegalArgumentException: First name is too long")
	@Test
	void testSetFirstNameTooLong() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()-> {
			Contact testContact = new Contact("James", "Ford", "2500 North River Road", "2075555456");
			testContact.setFirstName("Tyrannosaurus");
		});
		assertEquals("first name must not be null, empty, or greater than 10 characters", exception.getMessage());
	}
	
	
	@DisplayName("Expected to Throw IllegalArgumentException: Full name is empty")
	@Test
	void testSetFullNameEmpty() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()-> {
			Contact testContact = new Contact("James", "Ford", "2500 North River Road", "2075555456");
			testContact.setName("","");
		});
		assertEquals("first and last name must not be null, empty, or greater than 10 characters", exception.getMessage());
	}
	
	
	@DisplayName("Expected to Throw IllegalArgumentException: Last name is empty")
	@Test
	void testSetLastNameEmpty() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()-> {
			Contact testContact = new Contact("James", "Ford", "2500 North River Road", "2075555456");
			testContact.setLastName("");
		});
		assertEquals("last name must not be null, empty, or greater than 10 characters", exception.getMessage());
	}
	
	
	@DisplayName("Expected to Throw IllegalArgumentException: address is empty")
	@Test
	void testSetAddressEmpty() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()-> {
			Contact testContact = new Contact("James", "Ford", "2500 North River Road", "2075555456");
			testContact.setAddress("");
		});
		assertEquals("address must not be null, empty, or greater than 30 characters", exception.getMessage());
	}
	
	
	@DisplayName("Expected to Throw IllegalArgumentException: Last name is too long")
	@Test
	void testSetLastNameTooLong() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()-> {
			Contact testContact = new Contact("James", "Ford", "2500 North River Road", "2075555456");
			testContact.setLastName("Tyrannosaurus");
		});
		assertEquals("last name must not be null, empty, or greater than 10 characters", exception.getMessage());
	}
	
}
