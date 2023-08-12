package com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.user_subclasses.LoggedInUser;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.login_subclasses.VerifyLoginData;

import junit.framework.TestCase;

import java.util.HashMap;

public class LoginTest extends TestCase {

    private static final String USERNAME = "testUser";
    private static final String PASSWORD = "testPassword";
    private static final String EMAIL = "test@example.com";

    // Test method to check if getUsername() returns the correct username
    public void testGetUsername() {
        Login login = new VerifyLoginData(USERNAME, PASSWORD, EMAIL, null); // Using VerifyLoginData for testing
        assertEquals(USERNAME, login.getUsername());
    }

    // Test method to check if getPassword() returns the correct password
    public void testGetPassword() {
        Login login = new VerifyLoginData(USERNAME, PASSWORD, EMAIL, null);
        assertEquals(PASSWORD, login.getPassword());
    }

    // Test method to check if getEmail() returns the correct email
    public void testGetEmail() {
        Login login = new VerifyLoginData(USERNAME, PASSWORD, EMAIL, null);
        assertEquals(EMAIL, login.getEmail());
    }

    // Test method to check if getUser() returns a non-null User object with correct attributes
    public void testGetUser() {
        Login login = new VerifyLoginData(USERNAME, PASSWORD, EMAIL, null);
        assertNotNull(login.getUser());
        assertEquals(USERNAME, login.getUser().getUsername());
        assertEquals(EMAIL, login.getUser().getEmail());
        assertEquals(PASSWORD, login.getUser().getPassword());
    }

    // Test method to check if getLoginCredentials() returns the expected login credentials map
    public void testGetLoginCredentials() {
        VerifyLoginData login = new VerifyLoginData(USERNAME, PASSWORD, EMAIL, null);
        HashMap<String, Object> expectedCredentials = new HashMap<>();
        expectedCredentials.put("username", USERNAME);
        expectedCredentials.put("email", EMAIL);
        expectedCredentials.put("password", PASSWORD);

        assertEquals(expectedCredentials, login.getLoginCredentials());
    }

    // Test method to check if getUserData() returns the expected user data map
    public void testGetUserData() {
        VerifyLoginData login = new VerifyLoginData(USERNAME, PASSWORD, EMAIL, null);
        HashMap<String, Object> expectedUserData = new HashMap<>();
        User user = new LoggedInUser(USERNAME, EMAIL, PASSWORD);
        expectedUserData.put(USERNAME, user);

        HashMap<String, Object> userData = login.getUserData();
        User retrievedUser = (User) userData.get(USERNAME);

        assertEquals(expectedUserData.size(), userData.size());
        assertEquals(user.getUsername(), retrievedUser.getUsername());
        assertEquals(user.getEmail(), retrievedUser.getEmail());
        assertEquals(user.getPassword(), retrievedUser.getPassword());
    }
}
