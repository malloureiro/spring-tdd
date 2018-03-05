package com.hanselnpetal.data.repos;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.hanselnpetal.domain.CustomerContact;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class CustomerContactManagementRepositoryIntegrationTest {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private CustomerContactRepository contactRepository;
	
	@Test
	public void testFindByEmail() {
		
		CustomerContact newContact = new CustomerContact();
		newContact.setEmail("paul@email.com");
		entityManager.persist(newContact); //save in database for test purpose and then rollback
		
		CustomerContact foundContact = contactRepository.findByEmail("paul@email.com");
		
		assertThat(foundContact.getEmail(), is(equalTo("paul@email.com")));
	}
}
