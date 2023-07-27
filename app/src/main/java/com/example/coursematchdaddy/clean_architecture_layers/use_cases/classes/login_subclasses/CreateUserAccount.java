package com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.login_subclasses;

import com.example.coursematchdaddy.clean_architecture_layers.gateways.classes.DBUsersGateway;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.Login;

import java.util.HashMap;

public class CreateUserAccount extends Login {
    /**
     * Constructs a new Login instance with the provided login credentials.
     * Aswell as a user object to represent the user trying to log in.
     *
     * @param username The username of the user for the login.
     * @param password The password of the user for the login.
     * @param email    The email of the user for the login.
     * @param gateway
     */
    public CreateUserAccount(String username, String password, String email, DBUsersGateway gateway) {
        super(username, password, email);
    }

    @Override
    public HashMap<String, Object> getUsersDataMap() {
        return null;
    }

    public boolean createAccount() {
        return true;
    }
}
