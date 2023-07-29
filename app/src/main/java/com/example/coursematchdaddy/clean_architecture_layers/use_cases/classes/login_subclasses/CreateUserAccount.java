/**
 * The CreateUserAccount class is responsible for creating user accounts and writing the account
 * information to the database using the DBUsersGateway. It extends the DBUsersGateway class
 * to access the necessary database functionality.
 */
package com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.login_subclasses;

import com.example.coursematchdaddy.clean_architecture_layers.gateways.classes.DBUsersGateway;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateUserAccount extends DBUsersGateway {

    /**
     * Creates a new CreateUserAccount object with the specified username, password, and email.
     *
     * @param username The username of the user for the login.
     * @param password The password of the user for the login.
     * @param email    The email of the user for the login.
     */
    private String username;
    private String email;
    private String password;

    public CreateUserAccount(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
