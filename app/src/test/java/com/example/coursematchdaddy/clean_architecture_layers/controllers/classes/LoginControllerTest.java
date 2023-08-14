package com.example.coursematchdaddy.clean_architecture_layers.controllers.classes;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.presenters.classes.LoginPresenter;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.login_class_imports_implementations.VerifyLoginDataInterface;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.login_class_imports_implementations.CreateUserAccountInterface;

import junit.framework.TestCase;

public class LoginControllerTest extends TestCase {

    public void testStoreUsername() {
        // Create a LoginController instance for testing
        LoginController loginController = new LoginController(new LoginPresenter(), null, null);

        // Store a username
        loginController.storeUsername("testUser");

        // Check if the stored username matches the expected value
        assertEquals("testUser", loginController.getUsername());
    }

    public void testStorePassword() {
        // Create a LoginController instance for testing
        LoginController loginController = new LoginController(new LoginPresenter(), null, null);

        // Store a password
        loginController.storePassword("testPassword");

        // Check if the stored password matches the expected value
        assertEquals("testPassword", loginController.getPassword());
    }

    public void testStoreEmail() {
        // Create a LoginController instance for testing
        LoginController loginController = new LoginController(new LoginPresenter(), null, null);

        // Store an email
        loginController.storeEmail("test@example.com");

        // Check if the stored email matches the expected value
        assertEquals("test@example.com", loginController.getEmail());
    }

    public void testValidateData() {
        // Create a mock implementation of VerifyLoginDataInterface for testing
        VerifyLoginDataInterfaceMock mock = new VerifyLoginDataInterfaceMock();

        // Create a LoginController instance with the mock implementation for testing
        LoginController loginController = new LoginController(new LoginPresenter(), mock, null);

        // Set username and password
        loginController.storeUsername("testUser");
        loginController.storePassword("testPassword");

        // Call the validateData method
        boolean isValid = loginController.validateData();

        // Check if the displayed message matches the expected value from the mock
        assertEquals("Login Validated!", loginController.getPresenter().getDisplayMessage());
        assertTrue(isValid);
    }

    public void testCreateAccount() {
        // Create a mock implementation of CreateUserAccountInterface for testing
        CreateUserAccountInterfaceMock mock = new CreateUserAccountInterfaceMock();

        // Create a LoginController instance with the mock implementation for testing
        LoginController loginController = new LoginController(new LoginPresenter(), null, mock);

        // Set username, password, and email
        loginController.storeUsername("testUser");
        loginController.storePassword("testPassword");
        loginController.storeEmail("test@example.com");

        // Call the createAccount method
        boolean accountCreated = loginController.createAccount();

        // Check if the displayed message matches the expected value from the mock
        assertEquals("Account successfully created!", loginController.getPresenter().getDisplayMessage());
        assertTrue(accountCreated);
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
            return false;//For testing purposes
        }

        @Override
        public boolean checkUsernameUniqueness(String providedUsername) {
            return false;//For testing purposes
        }
    }

    // Mock implementation of CreateUserAccountInterface for testing
    private class CreateUserAccountInterfaceMock implements CreateUserAccountInterface {

        @Override
        public boolean updateUserData(User userData) {
            return false;//For testing purposes
        }

        @Override
        public boolean verifyUser(User user) {
            return true;//For testing purposes
        }

        @Override
        public boolean removeUser(User user) {
            return false;//For testing purposes
        }
    }
}
