package com.hanselnpetal.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.GsonTester;
import org.springframework.test.context.junit4.SpringRunner;

import com.hanselnpetal.domain.CustomerContact;

@RunWith(SpringRunner.class)
@JsonTest
public class ContactsManagementJsonTest {
	
	@Autowired
	private GsonTester<CustomerContact> gsonTester;
	
	@Test
	public void testSerializer() throws IOException {
		
		CustomerContact contact = getContact();
		
		assertThat(gsonTester.write(contact)).isEqualToJson("expected.json");
	}
	
	private CustomerContact getContact() {
		CustomerContact contact = new CustomerContact();
		contact.setFirstName("Mariana");
		contact.setLastName("Loureiro");
		contact.setEmail("myemail@mail.com");
		contact.setDeliveryAddressState("Sao Paulo");
		contact.setDeliveryAddressCity("Sorocaba");
		return contact;
	}

}
