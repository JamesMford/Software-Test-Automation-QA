package com.snhu;

import java.util.ArrayList;
import java.util.Scanner;
@SuppressWarnings("unused") // scanner suppressed for testing

public class ContactService {
    private static ArrayList<Contact> contactsList = new ArrayList<>();
     

    public static void main(String[] args) {
    	
        
  
   }
    
    
/*
 * Functionality commented out for testing purposes
 * 
    public static void deleteContact(Scanner scanner) {
        System.out.println("Enter a contact ID to delete:");
        String findID = scanner.nextLine();
        
        // Search contact ID's for a match, then remove it
        boolean removed = contactsList.removeIf(contact -> contact.getId().equals(findID));
        
        if (removed) {
            System.out.println("Contact with ID " + findID + " successfully deleted.");
        } else {
            System.out.println("Contact ID not found.");
        }
        
    }
  */
    
     // Test delete functionality without input  
    public static void deleteContact() {
    		contactsList.remove(0);
    }
    
    // Test method to empty list between tests
    public static void clearContacts() {
    	contactsList.clear();
    }
    
    public static ArrayList<Contact> getContactsList(){
    	return contactsList;
    }
    
    public static void displayAllContacts() {
    	if(contactsList.isEmpty()) {
    		throw new IllegalArgumentException("No contacts to display");
    	}
    	else {
    		for(Contact c: contactsList) {
        		c.displayContact();
        	}
    	}
    	
    }
    
    public static void addContact(Contact contact) {
    	if(contact != null) {
    		contactsList.add(contact);
    	} else {
    		throw new IllegalArgumentException("Must enter contact information");
    	}
    }
    
    // Production code would utilize a scanner to input the contact ID
    // Temporarily allows parameters for testing
    public static void updateContact(String targetID, String attribute, String newValue) {
        System.out.println("Enter the Contact ID to Update");
        
        // Simulate user input for ID
        //String targetID = "2075555456"; 
        
        // Track if we actually find and update the contact
        boolean contactFound = false;

        for (Contact c : contactsList) {
            if (c.getId().equals(targetID)) { 
                contactFound = true;
                        
                
                // Handle the update based on the chosen attribute
                switch (attribute.toLowerCase()) {
                    case "first name":
                        c.setFirstName(newValue);
                        break;
                    case "last name":
                        c.setLastName(newValue);
                        break;
                    case "address":
                        c.setAddress(newValue);
                        break;
                    case "phone number":
                        c.setNumber(newValue);
                        break;
                    default:
                    	throw new IllegalArgumentException("must enter an attribute to update");
                }
                
                System.out.println("Contact updated successfully!");
                break; // Stop looping once the contact is found and updated
            }
        }

        if (!contactFound) {
            System.out.println("ID not found");
        }
    }
    
}

