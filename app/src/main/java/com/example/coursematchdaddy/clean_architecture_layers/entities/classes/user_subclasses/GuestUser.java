package com.example.coursematchdaddy.clean_architecture_layers.entities.classes.user_subclasses;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;

public class GuestUser extends User {
    /**
     * Constructor method for the User class.
     *
     */
    public GuestUser() {
        super("username", "email", "password");
    }
}
