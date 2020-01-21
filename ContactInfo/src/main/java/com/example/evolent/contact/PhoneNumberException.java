package com.example.evolent.contact;

public class PhoneNumberException extends RuntimeException{
	PhoneNumberException() {
	    super("Please enter 10 digit mobile number ");
	  }
}
