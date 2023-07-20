package com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.login_class_imports_implementations;

import com.example.coursematchdaddy.clean_architecture_layers.gateways.classes.DBUsersGateway;

public interface CreateUserAccountInterface {
    /**
     * Adds a username to the persistence.
     *
     * @param username The username to be added.
     * @return true if the username is successfully added and is unique else return false.
     */
    public boolean addUsername(String username);

    /**
     * Adds a password to the persistence.
     *
     * @param password The password to be added.
     * @return true if the password is successfully added and meets security requirements else return false.
     */
    public boolean addPassword(String password);

    /**
     * Adds email to persistence.
     *
     * @param email The email to be added.
     * @return if the email is successfully added and is valid else return false.
     */
    public boolean addEmail(String email);

}
