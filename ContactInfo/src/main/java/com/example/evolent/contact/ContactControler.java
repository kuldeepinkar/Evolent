package com.example.evolent.contact;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactControler {

	@Autowired
	private ContactService contactService;
	
	@RequestMapping("/contacts")
	public List<Contact> getAllContact()
	{
	     return	contactService.getAllContact();
	}
	
	@RequestMapping("/contacts/{id}")
	public Contact getContact(@PathVariable("id") Integer id)
	{
	     return	contactService.getContact(id);
	}
	
	
	@RequestMapping(value ="/contacts" ,method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void addContact(@RequestBody Contact contact)
	{
	    	contactService.addContact(contact);
	}
	
	  @RequestMapping(value ="/contacts/{id}",method = RequestMethod.PUT) public
	  void updateContact(@RequestBody Contact contact ,@PathVariable("id") Integer id ) {
	  contactService.updateContact(contact,id); 
	  }
	 
	
	@RequestMapping(value ="/contacts/{id}", method = RequestMethod.DELETE )
	public void deleteContact(@PathVariable("id") Integer id)
	{
	    	contactService.deleteContact(id);
	}
	
}
