package com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.login_class_imports_implementations;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.gateways.classes.DBUsersGateway;

import java.util.HashMap;

public interface VerifyLoginDataInterface {
    /**
     * Verifies the user's provided log in credentials.
     *
     * @param providedUsername Given username
     * @param providedPassword given password
     * @return true if the username is valid and matches an existing user account, false otherwise.
     */
    public boolean verifyUserProvidedData(String providedUsername, String providedPassword);

    /**
     * check if the email entered is unique in the database
     * @param providedEmail email entered
     * @return true if email is unique, false otherwise
     */
    public boolean checkEmailUniqueness(String providedEmail);

    /**
     * check if the username entered is unique in the database
     *
     * @param providedUsername username entered
     * @return true if the username entered is unique, false otherwise
     */
    public boolean checkUsernameUniqueness(String providedUsername);
}
