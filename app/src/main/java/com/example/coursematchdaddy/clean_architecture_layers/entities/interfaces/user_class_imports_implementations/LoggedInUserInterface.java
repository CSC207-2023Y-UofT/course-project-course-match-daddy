package com.example.coursematchdaddy.clean_architecture_layers.entities.interfaces.user_class_imports_implementations;

import java.util.HashMap;

public interface LoggedInUserInterface {

    /**
     * Get the login credentials of the logged-in user.
     *
     * @return A HashMap containing the login credentials as key-value pairs
     */
    HashMap<String, Object> getLoginCredentials();

    /**
     * Get the user data of the logged-in user.
     *
     * @return A HashMap containing the user data as key-value pairs
     */
    HashMap<String, Object> getUserData();
}