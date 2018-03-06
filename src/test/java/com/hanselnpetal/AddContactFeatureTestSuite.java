package com.hanselnpetal;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.hanselnpetal.controller.ContactsManagementControllerIntegrationTest;
import com.hanselnpetal.data.repos.CustomerContactManagementRepositoryIntegrationTest;
import com.hanselnpetal.service.ContactsManagementServiceIntegrationTest;

@RunWith(Suite.class)
@SuiteClasses({ContactsManagementServiceIntegrationTest.class,
	ContactsManagementControllerIntegrationTest.class,
	CustomerContactManagementRepositoryIntegrationTest.class})
public class AddContactFeatureTestSuite {

}
