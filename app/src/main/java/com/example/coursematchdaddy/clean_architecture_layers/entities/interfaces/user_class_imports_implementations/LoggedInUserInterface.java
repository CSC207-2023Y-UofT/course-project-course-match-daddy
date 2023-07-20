package com.example.coursematchdaddy.clean_architecture_layers.entities.interfaces.user_class_imports_implementations;

import java.util.HashMap;

/**
 * The LoggedInUserInterface represents a user who is currently logged in to the system.
 * It provides methods to access the login credentials and user data associated with the logged-in user.
 */
public interface LoggedInUserInterface {

    /**
     * Get the login credentials of the logged-in user.
     *
     * @return A HashMap containing the login credentials as key-value pairs, where the keys represent
     *         different pieces of login information (e.g., username, email, etc.), and the values are
     *         corresponding objects representing the login data.
     */
    HashMap<String, Object> getLoginCredentials();

    /**
     * Get the user data of the logged-in user.
     *
     * @return A HashMap containing the user data as key-value pairs, where the keys represent
     *         different pieces of user information (e.g., name, age, address, etc.), and the values are
     *         corresponding objects representing the user data.
     */
    HashMap<String, Object> getUserData();
}
