package com.hanselnpetal.controller;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.hanselnpetal.domain.CustomerContact;
import com.hanselnpetal.service.ContactsManagementService;

@RunWith(SpringRunner.class)
@WebMvcTest(ContactsManagementMvcController.class)
public class ContactsManagementControllerUnitTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ContactsManagementService contactsService;
	
	@InjectMocks
	private ContactsManagementMvcController contactsController;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testAddContactHappyPath() throws Exception {
		
		CustomerContact mockContact = new CustomerContact();
		mockContact.setFirstName("Louis");
		mockContact.setLastName("Armstrong");
		
		when(contactsService.add(any(CustomerContact.class))).thenReturn(mockContact);
		
		CustomerContact newContact = new CustomerContact();
		newContact.setFirstName("Louis");
		newContact.setEmail("louis@email.com");
		
		mockMvc.perform(post("/addContact", newContact))
				.andExpect(status().isOk())
				.andReturn();
	}
	
	@Test
	public void testAddContactRuleNotSatisfied() throws Exception {
		
		when(contactsService.add(any(CustomerContact.class))).thenReturn(null);
		
		CustomerContact newContact = new CustomerContact();
		newContact.setLastName("Ramos");
		
		mockMvc.perform(post("/addContact", newContact))
		.andExpect(status().is(302))
		.andReturn();
		
	}
	
}
