package com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.login_subclasses;

import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.login_class_imports_implementations.VerifyLoginDataInterface;

import junit.framework.TestCase;

public class VerifyLoginDataTest extends TestCase {

    public void testVerifyData() {
        // Create a mock implementation of VerifyLoginDataInterface for testing
        VerifyLoginDataInterfaceMock mock = new VerifyLoginDataInterfaceMock();

        // Create an instance of VerifyLoginData with mock implementation
        VerifyLoginData verifyLoginData = new VerifyLoginData("testUser", "testPassword", "test@example.com", mock);

        // Call the verifyData method
        boolean isValid = verifyLoginData.verifyData();

        // Check if the returned result matches the expected value from the mock
        assertTrue(isValid);
    }

    // Mock implementation of VerifyLoginDataInterface for testing
    private class VerifyLoginDataInterfaceMock implements VerifyLoginDataInterface {
        @Override
        public boolean verifyUserProvidedData(String username, String password) {
            // Mocking the verification process, always returning true for testing purposes
            return true;
        }

        @Override
        public boolean checkEmailUniqueness(String providedEmail) {
            return false;//for testing purposes
        }

        @Override
        public boolean checkUsernameUniqueness(String providedUsername) {
            return false;//for testing purposes
        }
    }
}
