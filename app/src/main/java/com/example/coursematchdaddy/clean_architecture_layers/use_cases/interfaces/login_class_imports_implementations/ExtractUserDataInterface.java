package com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.login_class_imports_implementations;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;

// Provides the method(s) to retrieve a user’s data from a table within the database.
public interface ExtractUserDataInterface {
    /**
     * Retrieve a user's data from a database.
     *
     * @param email This is a unique identifier for a user.
     * @return Return a user's data.
     */
    public User getUserData(String email);

    /**
     * Retrieve a user's data from a database.
     *
     * @param username This is a unique identifier for a user.
     * @return Return a user's data.
     */
    public User getUserFromDB(String username);
}