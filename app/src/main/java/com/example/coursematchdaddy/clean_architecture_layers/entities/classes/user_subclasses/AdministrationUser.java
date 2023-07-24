package com.example.coursematchdaddy.clean_architecture_layers.entities.classes.user_subclasses;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;

public class AdministrationUser extends LoggedInUser {
    /**
     * Constructor method for the User class.
     *
     * @param username This is the username of a user; this is a unique identifier for the user.
     * @param email    This is the email of a user; this is a unique identifier for the user.
     * @param password This is the password of a user.
     */
    public AdministrationUser(String username, String email, String password) {
        super(username, email, password);
    }
}
