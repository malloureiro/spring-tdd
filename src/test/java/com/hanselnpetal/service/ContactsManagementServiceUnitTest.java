package com.hanselnpetal.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.hanselnpetal.data.repos.CustomerContactRepository;
import com.hanselnpetal.domain.CustomerContact;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment= WebEnvironment.NONE)
public class ContactsManagementServiceUnitTest {
	
	
	@Mock
	private CustomerContactRepository contactRepository;
	
	@InjectMocks
	private ContactsManagementService contactsService;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testAddContactHappyPath() {
		
		CustomerContact mockContact = new CustomerContact();
		mockContact.setFirstName("Mariana");
		mockContact.setLastName("Loureiro");
		
		Mockito.when(contactRepository.save(Mockito.any(CustomerContact.class))).thenReturn(mockContact);
		
		CustomerContact empty = new CustomerContact();
		CustomerContact newContact = contactsService.add(empty);
		
		assertEquals(newContact.getFirstName(), mockContact.getFirstName());
		
	}

}
