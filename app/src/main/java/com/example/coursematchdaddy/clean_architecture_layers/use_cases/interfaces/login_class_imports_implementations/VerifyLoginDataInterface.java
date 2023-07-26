package com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.login_class_imports_implementations;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.gateways.classes.DBUsersGateway;

public interface VerifyLoginDataInterface {

    /**
     * Verifies the correctness of the provided username in the user data.
     *
     * @param userData The User object containing the user data, including the username to be verified.
     * @return true if the username is valid and matches an existing user account, false otherwise.
     */
    boolean verifyUsername(User userData);

    /**
     * Verifies the correctness of the provided password in the user data.
     *
     * @param userData The User object containing the user data, including the password to be verified.
     * @return true if the password is valid and matches the corresponding user's password, false otherwise.
     */
    boolean verifyPassword(User userData);

    /**
     * Verifies the correctness of the provided email in the user data.
     *
     * @param userData The User object containing the user data, including the email to be verified.
     * @return true if the email is valid and matches an existing user account, false otherwise.
     */
    boolean verifyEmail(User userData);

}