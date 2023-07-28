package com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.login_subclasses;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.gateways.classes.DBUsersGateway;
import com.example.coursematchdaddy.clean_architecture_layers.gateways.classes.GETCourseGateway;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.Login;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class CreateUserAccount extends DBUsersGateway {
    /**
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

    public boolean createAccount(User userdata) {
        try (FileWriter writer = new FileWriter(super.getuserDataPath(), true)) {
            writer.append(this.username);
            writer.append(",");
            writer.append(this.email);
            writer.append(",");
            writer.append(this.password);
            writer.append("\n");

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error occurred while writing to the CSV file.");
            return false;//failed to create account
        }
        return true;//Made account
    }
}
