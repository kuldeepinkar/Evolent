package com.example.evolent.contact;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "contacts")
public class Contact {
	
@Id
@GeneratedValue
@Column(name = "id")
int id;

@Column(name = "first_name")
String firstName;

@Column(name = "last_name")
String lastName;

@Column(name = "email")
String email;

@Column(name = "phone_number")
String phoneNumber;

@Column(name = "active")
boolean active;

public Contact() {
	super();
}

public Contact(int id, String firstName, String lastName, String email, String phoneNumber, boolean active) {
	super();
	id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.phoneNumber = phoneNumber;
	active = active;
}

public int getId() {
	return id;
}

public void setId(int id) {
	id = id;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPhoneNumber() {
	return phoneNumber;
}

public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}

public boolean isActive() {
	return active;
}

public void setActive(boolean active) {
	this.active = active;
}

@Override
public String toString() {
	return "Contact [Id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
			+ ", phoneNumber=" + phoneNumber + ", Active=" + active + "]";
}




}
