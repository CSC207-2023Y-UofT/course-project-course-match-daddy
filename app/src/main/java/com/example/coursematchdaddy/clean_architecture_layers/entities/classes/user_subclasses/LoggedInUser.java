package com.example.coursematchdaddy.clean_architecture_layers.entities.classes.user_subclasses;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;

public class LoggedInUser extends User {
    public LoggedInUser(String username, String email, String password) {
        super(username, email, password);
    }
}
