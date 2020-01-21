package com.example.evolent.contact;

class ContactNotFoundException extends RuntimeException {
	
	ContactNotFoundException(int id) {
	    super("Could not find contact " + id);
	  }
	
	ContactNotFoundException() {
	    super("No contacts present ");
	  }
	
	}