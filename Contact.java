package com.snhu;


public class Contact {
	private String firstName;
	private String lastName;
	private String address;
	private String phoneNumber;
	private String contactId;
	
	
	public Contact(String firstName, String lastName, String address, String phoneNumber) {
		
		if(firstName == null || firstName.isEmpty() || firstName.length() > 10) {
			throw new IllegalArgumentException("first name must not be null, empty, or greater than 10 characters");	
		}
		else {
			this.firstName = firstName;
		}
		if(lastName == null || lastName.isEmpty() || lastName.length() > 10) {
			throw new IllegalArgumentException("last name must not be null, empty, or greater than 10 characters");
		}
		else {
			this.lastName = lastName;
		}
		if(address == null || address.isEmpty() || address.length() > 30) {
			throw new IllegalArgumentException("address must not be null, empty, or greater than 30 characters");
		}
		else {
			this.address = address;
		}
		if(phoneNumber == null || phoneNumber.isEmpty() || phoneNumber.length() != 10) {
			throw new IllegalArgumentException("phone number must not be null or empty, and have 10 digits");
		}
		else {
			this.phoneNumber = phoneNumber;
		}
		this.contactId = IdGenerator.generateID();
	}
	
	// display individual contact
	public void displayContact() {
		System.out.println(this.firstName + " " + this.lastName + " | " + this.address + " | " + this.phoneNumber
				+ " | " + this.contactId);
	}
	
	
	
	// setters and getters 
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getName() {
		return firstName + " " + lastName;
	}
	
	public void setFirstName(String firstName) {
		if(firstName == null || firstName.isEmpty() || firstName.length() > 10) {
			throw new IllegalArgumentException("first name must not be null, empty, or greater than 10 characters");	
		}		
		else {
			this.firstName = firstName;
		}
	}
	
	public void setLastName(String lastName) {
		if(lastName == null || lastName.isEmpty() || lastName.length() > 10) {
			throw new IllegalArgumentException("last name must not be null, empty, or greater than 10 characters");
		}
		else {
			this.lastName = lastName;
		}	
	}
	
	public void setName(String firstName, String lastName) {
		
		if(firstName == null || firstName.isEmpty() || firstName.length() > 10) {
			throw new IllegalArgumentException("first and last name must not be null, empty, or greater than 10 characters");
			
		}
		
		else {
			this.firstName = firstName;
		}
		
		if(lastName == null || lastName.isEmpty() || lastName.length() > 10) {
			throw new IllegalArgumentException("last name must not be null, empty, or greater than 10 characters");
		}
		else {
			this.lastName = lastName;
		}
	}
	
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		if(address == null || address.isEmpty() || address.length() > 30) {
			throw new IllegalArgumentException("address must not be null, empty, or greater than 30 characters");
		}
		else {
			this.address = address;
		}
		
	}
	
	public String getNumber() {
		return phoneNumber;
	}
	
	public void setNumber(String number) {
		if(number == null || number.isEmpty() || number.length() != 10) {
			throw new IllegalArgumentException("Enter a phone number");
		}
		else {
			this.phoneNumber = number;
		}
		
	}
	
	public String getId() {
		return contactId;
	}
	
} // class