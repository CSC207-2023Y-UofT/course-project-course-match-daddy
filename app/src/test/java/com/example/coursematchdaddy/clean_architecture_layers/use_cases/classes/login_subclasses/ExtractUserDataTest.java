package com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.login_subclasses;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.user_subclasses.LoggedInUser;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.login_class_imports_implementations.ExtractUserDataInterface;

import junit.framework.TestCase;

import java.util.HashMap;

public class ExtractUserDataTest extends TestCase {

    public void testGetUserData() {
        // Create a mock implementation of ExtractUserDataInterface for testing
        ExtractUserDataInterfaceMock mock = new ExtractUserDataInterfaceMock();

        // Create an instance of ExtractUserData with mock implementation
        ExtractUserData extractUserData = new ExtractUserData("testUser", "testPassword", "test@example.com", mock);

        // Call the getUserData method
        HashMap<String, Object> userData = extractUserData.getUserData();

        // Check if the returned user data matches the expected values from the mock
        assertEquals(mock.expectedUserData, userData);
    }

    // Mock implementation of ExtractUserDataInterface for testing
    private class ExtractUserDataInterfaceMock implements ExtractUserDataInterface {
        User user;
        HashMap<String, Object> expectedUserData = new HashMap<>();

        ExtractUserDataInterfaceMock() {
            // Create a sample User object with mock survey and data
            user = new LoggedInUser("testUser", "testPassword", "test@example.com");

            // Create the expected user data HashMap
            expectedUserData.put("survey", user.getUserSurveyData());
            expectedUserData.put("password", user.getPassword());
            expectedUserData.put("username", user.getUsername());
            expectedUserData.put("email", user.getEmail());
        }

        @Override
        public User getUserData(String email) {
            return user;//Just for testing purposes
        }

        @Override
        public User getUserFromDB(String username) {
            return null;//Just for testing purposes
        }
    }
}
