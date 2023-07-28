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

    /**
     * Creates a new user account and writes the user information to the database.
     *
     * @return true if the account creation is successful, false otherwise.
     */
    public boolean createAccount() {
        try {
            // Get the file path for the user data from the DBUsersGateway
            File file = new File(super.getuserDataPath());
            try (FileWriter writer = new FileWriter(file, true)) {
                // Write the user information to the file in CSV format
                writer.append(this.username);
                writer.append(",");
                writer.append(this.email);
                writer.append(",");
                writer.append(this.password);
                writer.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false; // failed to create account
        }
        return true; // Made account
    }
}
