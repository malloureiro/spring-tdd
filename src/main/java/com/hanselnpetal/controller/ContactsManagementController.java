package com.hanselnpetal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hanselnpetal.domain.CustomerContact;
import com.hanselnpetal.service.ContactsManagementService;

@RestController
@RequestMapping("/contact")
public class ContactsManagementController {

	@Autowired
	private ContactsManagementService contactsService;
	
	@PostMapping("/add")
	public String addContact(@RequestBody CustomerContact contact) {
		
		CustomerContact customerContact = contactsService.add(contact);
		
		if (customerContact != null) {
			return "success";
		}
		
		return "failure";
	}
	
}
