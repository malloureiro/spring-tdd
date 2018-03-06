package com.hanselnpetal;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.hanselnpetal.controller.ContactsManagementControllerIntegrationTest;

@RunWith(Suite.class)
@SuiteClasses ({ DatastoreSystemsHealthTest.class, ContactsManagementControllerIntegrationTest.class })

public class ContinuousIntegrationTestSuite {

	// intentionally empty - Test Suite Setup (annotations) is sufficient
}
