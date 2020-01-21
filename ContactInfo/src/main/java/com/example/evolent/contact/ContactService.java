package com.example.evolent.contact;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ContactService {

	@Autowired
	ContactRepository contactRepository;
	
	public List<Contact> getAllContact(){
		List<Contact> contacts=new ArrayList<>();
		contactRepository.findAll().forEach(contacts::add);
		/*
		 * if(contacts.isEmpty()) { throw new ContactNotFoundException(); }
		 */
		
		return contacts;
		
		
	}
	
	  public Contact getContact(Integer id) { 
	     return contactRepository.findById(id)
	    		 .orElseThrow(() -> new ContactNotFoundException(id));
	  }
	 
	public void addContact(Contact contact)
	{
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                "[a-zA-Z0-9_+&*-]+)*@" + 
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                "A-Z]{2,7}$";
		if((contact.getPhoneNumber().length()!=10)|| !(contact.getPhoneNumber().matches("[0-9]+")) )
		{
			throw  new PhoneNumberException();
		}
		else if((contact.getFirstName() == null) 
	            || (!contact.getFirstName().matches("^[a-zA-Z]*$"))) {
			throw  new NameException();
		}
		else if((contact.getLastName() == null) 
	            || (!contact.getLastName().matches("^[a-zA-Z]*$"))) {
			throw  new NameException();
		}
		else if(!contact.getEmail().matches(emailRegex)) {
			throw  new EmailException();
		}
		
		else {
		contactRepository.save(contact);
		}
	}
	
	public void deleteContact(Integer id)
	{ 
		try {
			contactRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			System.out.println("The contact is not present");
		}
	
	}

	public void updateContact(Contact contact ,Integer id) {
		
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                "[a-zA-Z0-9_+&*-]+)*@" + 
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                "A-Z]{2,7}$";
		if((contact.getPhoneNumber().length()!=10)|| !(contact.getPhoneNumber().matches("[0-9]+")) )
		{
			throw  new PhoneNumberException();
		}
		else if((contact.getFirstName() == null) 
	            || (!contact.getFirstName().matches("^[a-zA-Z]*$"))) {
			throw  new NameException();
		}
		else if((contact.getLastName() == null) 
	            || (!contact.getLastName().matches("^[a-zA-Z]*$"))) {
			throw  new NameException();
		}
		else if(!contact.getEmail().matches(emailRegex)) {
			throw  new EmailException();
		}
		
		Contact pantsInDB = contactRepository.findById(id).get(); 
		pantsInDB.setFirstName(contact.getFirstName());
		pantsInDB.setLastName(contact.getLastName());
		pantsInDB.setEmail(contact.getEmail());
		pantsInDB.setActive(contact.isActive());
		pantsInDB.setPhoneNumber(contact.getPhoneNumber());
		contactRepository.save(pantsInDB);
		
	}
	
}
