package com.example.coursematchdaddy.clean_architecture_layers.entities.interfaces.user_class_imports_implementations;

import java.util.HashMap;

// Provides the method(s) for manipulating the application's users' data.
public interface AdministrationUserInterface {
    /**
     * Retrieve a user's login credentials.
     *
     * @return Retrieve a user's login credentials.
     */
    public HashMap<String, Object> getLoginCredentials();

    /**
     * Retrieve a user's data.
     *
     * @return Retrieve a user's data.
     */
    public HashMap<String, Object> getUserData();

    /**
     * Retrieve a users' data.
     *
     * @return Retrieve a users' data.
     */
    public HashMap<String, Object> getUsersDataMap();
}
