package com.example.coursematchdaddy.clean_architecture_layers.presenters.classes;

import junit.framework.TestCase;

public class LoginPresenterTest extends TestCase {

    public void testSetDisplayMessage() {
        // Create an instance of LoginPresenter for testing
        LoginPresenter loginPresenter = new LoginPresenter();

        // Set a display message
        loginPresenter.setDisplayMessage("Test message");

        // Check if the stored display message matches the expected value
        assertEquals("Test message", loginPresenter.getDisplayMessage());
    }

    public void testGetDisplayMessage() {
        // Create an instance of LoginPresenter for testing
        LoginPresenter loginPresenter = new LoginPresenter();

        // Set a display message
        loginPresenter.setDisplayMessage("Test message");

        // Call the getDisplayMessage method
        String displayMessage = loginPresenter.getDisplayMessage();

        // Check if the returned display message matches the expected value
        assertEquals("Test message", displayMessage);
    }
}
