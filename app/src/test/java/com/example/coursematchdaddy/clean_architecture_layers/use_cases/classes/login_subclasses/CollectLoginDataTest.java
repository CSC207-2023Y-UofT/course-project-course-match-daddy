package com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.login_subclasses;

import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.login_class_imports_implementations.CollectLoginDataInterface;

import junit.framework.TestCase;

public class CollectLoginDataTest extends TestCase {

    public void testStoreData() {
        // Create a mock implementation of CollectLoginDataInterface for testing
        CollectLoginDataInterfaceMock mock = new CollectLoginDataInterfaceMock();

        // Create an instance of CollectLoginData with mock implementation
        CollectLoginData collectLoginData = new CollectLoginData("testUser", "testPassword", "test@example.com", mock);

        // Call the storeData method
        collectLoginData.storeData();

        // Check if the mock's methods were called with the correct values
        assertTrue(mock.emailStored);
        assertTrue(mock.passwordStored);
        assertTrue(mock.usernameStored);
    }

    // Mock implementation of CollectLoginDataInterface for testing
    private class CollectLoginDataInterfaceMock implements CollectLoginDataInterface {
        boolean emailStored = false;
        boolean passwordStored = false;
        boolean usernameStored = false;

        @Override
        public void storeEmail(String email) {
            emailStored = true;
        }

        @Override
        public void storePassword(String password) {
            passwordStored = true;
        }

        @Override
        public void storeUsername(String username) {
            usernameStored = true;
        }
    }
}
