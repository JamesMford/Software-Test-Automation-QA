package com.snhu;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class ContactServiceTest {
	
	@BeforeEach
	// Clear the list before each test
	void setUp() {
		ContactService.clearContacts();
	}
	
	
	@DisplayName("Expected to successfully add a contact to the list")
	@Test
	void testAddContactToListSuccessfully() {
        // Create a new contact object
        Contact testContact = new Contact("James", "Ford", "2500 North River Road", "2075555456");
        
        // Confirm the list starts completely empty
        assertEquals(0, ContactService.getContactsList().size());

        // Add the contact using the service method
        ContactService.addContact(testContact);

        // Verify the list size increased to 1
        assertEquals(1, ContactService.getContactsList().size());
        
        // Verify the item inside matches our test object
        assertEquals(testContact, ContactService.getContactsList().get(0));      
    }
	
	
	@DisplayName("Expected to successfully delete a contact from the list")
	@Test
	void testDeleteContactSuccesfully() {
		
        // Create a new contact object
        Contact testContact = new Contact("James", "Ford", "2500 North River Road", "2075555456");
        
        // Add the contact using the service method
        ContactService.addContact(testContact);
        
        // Verify the list size increased to 1
        assertEquals(1, ContactService.getContactsList().size());
        
        // Verify the item inside matches our test object
        assertEquals(testContact, ContactService.getContactsList().get(0));
        
        // Delete created testContact
        ContactService.deleteContact();
        
        // Verify the list size decreased to 0 after the testContact is deleted
        assertEquals(0, ContactService.getContactsList().size());
	}
	
	@Test
	@DisplayName("Expected to successfully update a contact first name")
	void testUpdateContactSuccessfully() {
	    // Create a contact 
	    Contact testContact = new Contact("James", "Ford", "2500 North River Road", "2075555456");
	    ContactService.addContact(testContact); 
	    
	    String targetId = testContact.getId(); 

	    // Call the service method
	    ContactService.updateContact(targetId, "first name", "Jim");

	    // Get the updated contact
	    Contact updatedContact = ContactService.getContactsList().get(0); 
	    
	    // Check that the value changed
	    assertEquals("Jim", updatedContact.getFirstName());
	}
	
	
	@Test
	@DisplayName("Expected to successfully update a contact last name")
	void testUpdateContactLastName() {
	    // Create a contact 
	    Contact testContact = new Contact("James", "Ford", "2500 North River Road", "2075555456");
	    ContactService.addContact(testContact); 
	    
	    String targetId = testContact.getId(); 

	    // Call the service method
	    ContactService.updateContact(targetId, "last name", "Brown");

	    // Get the updated contact
	    Contact updatedContact = ContactService.getContactsList().get(0); 
	    
	    // Check that the value changed
	    assertEquals("Brown", updatedContact.getLastName());
	}
	
	
	@Test
	@DisplayName("Expected to successfully update a contact address")
	void testUpdateContactAddress() {
	    // Create a contact 
	    Contact testContact = new Contact("James", "Ford", "2500 North River Road", "2075555456");
	    ContactService.addContact(testContact); 
	    
	    String targetId = testContact.getId(); 

	    // Call the service method
	    ContactService.updateContact(targetId, "address", "128 Orange St. Auburn, ME");

	    // Get the updated contact
	    Contact updatedContact = ContactService.getContactsList().get(0); 
	    
	    // Check that the value changed
	    assertEquals("128 Orange St. Auburn, ME", updatedContact.getAddress());
	}
	
	
	@Test
	@DisplayName("Expected to successfully update a contact phone")
	void testUpdateContactPhone() {
	    // Create a contact 
	    Contact testContact = new Contact("James", "Ford", "2500 North River Road", "2075555456");
	    ContactService.addContact(testContact); 
	    
	    String targetId = testContact.getId(); 

	    // Call the service method
	    ContactService.updateContact(targetId, "phone number", "3125554647");

	    // Get the updated contact
	    Contact updatedContact = ContactService.getContactsList().get(0); 
	    
	    // Check that the value changed
	    assertEquals("3125554647", updatedContact.getNumber());
	}
	
	
	@Test
	@DisplayName("Expected to Throw IllegalArgumentException: no update attribute entered")
	void testInvalidUpdateAttribute() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()-> {
			// Create a contact 
		    Contact testContact = new Contact("James", "Ford", "2500 North River Road", "2075555456");
		    ContactService.addContact(testContact); 
		    
		    String targetId = testContact.getId(); 

		    // Call the service method
		    ContactService.updateContact(targetId, "", "3125554647");
		});
	    
			assertEquals("must enter an attribute to update", exception.getMessage());
	}
	
	
	@DisplayName("Expected to Throw IllegalArgumentException: First name is set to null")
	@Test
	void testSetFirstNameMethod() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()-> {
			Contact testContact = new Contact("James", "Ford", "2500 North River Road", "2075555456");
			testContact.setFirstName(null);
		});
		assertEquals("first name must not be null, empty, or greater than 10 characters", exception.getMessage());
	}
	
	
	@DisplayName("Expected to Throw IllegalArgumentException: Last name is empty")
	@Test
	void testSetLastNameMethod() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()-> {
			Contact testContact = new Contact("James", "Ford", "2500 North River Road", "2075555456");
			testContact.setLastName("");
		});
		assertEquals("last name must not be null, empty, or greater than 10 characters", exception.getMessage());
	}
	
	
	@Test
	@DisplayName("Expected to Successfully display contacts in contactsList")
	void testDisplayAllContacts() {
		
			// Create a contact 
		    Contact testContact1 = new Contact("James", "Ford", "2500 North River Road", "2075555456");
		    Contact testContact2 = new Contact("John", "Henry", "224 Holloway Rd", "2125556768");
		    
		    ContactService.addContact(testContact1);
		    ContactService.addContact(testContact2);
		    
		    assertEquals(2, ContactService.getContactsList().size());
	}
	    
	
	@Test
	@DisplayName("Expected to Successfully display contacts in contactsList")
	void testDisplayContacts() {
		
			// Create a contact 
		    Contact testContact1 = new Contact("James", "Ford", "2500 North River Road", "2075555456");
		    Contact testContact2 = new Contact("John", "Henry", "224 Holloway Rd", "2125556768");
		    
		    ContactService.addContact(testContact1);
		    ContactService.addContact(testContact2);
		    ContactService.displayAllContacts();    
		    assertEquals(2, ContactService.getContactsList().size());
	}
	
	
	@Test
	@DisplayName("Expected to Throw IllegalArgumentException: contact list can't be displayed if it's empty")
	void testEmptyContactsListException() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()-> {
		    
		    ContactService.displayAllContacts();
		});
		 assertEquals("No contacts to display", exception.getMessage());
	}
	
	
	
}
