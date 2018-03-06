package com.hanselnpetal.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.hanselnpetal.domain.CustomerContact;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ContactsManagementControllerIntegrationTest {

	@Autowired
	private ContactsManagementController contactsController;
	
	@Test
	public void testAddContactHappyPath() {
		
		CustomerContact newContact = new CustomerContact();
		newContact.setFirstName("Luke");
		newContact.setLastName("Cage");
		
		String response = contactsController.addContact(newContact);
		
		assertThat(response, is(equalTo("success")));
	}
	
	@Test
	public void testAddContactFirstNameMissing() {
		
		CustomerContact newContact = new CustomerContact();
		
		String response = contactsController.addContact(newContact);
		
		assertThat(response, is(equalTo("failure")));
	}
}
