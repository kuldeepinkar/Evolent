package com.example.evolent.contact;

public class EmailException extends RuntimeException{
	EmailException() {
	    super("Please enter correct Email address");
	  }
}