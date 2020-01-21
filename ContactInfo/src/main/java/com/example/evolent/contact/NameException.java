package com.example.evolent.contact;

public class NameException extends RuntimeException{
	NameException() {
	    super("Please enter correct first or last Name, It should contain only letters");
	  }
}
