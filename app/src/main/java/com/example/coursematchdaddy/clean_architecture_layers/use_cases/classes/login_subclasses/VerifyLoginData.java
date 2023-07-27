
package com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.login_subclasses;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.Login;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.login_class_imports_implementations.VerifyLoginDataInterface;

import java.util.HashMap;

public class VerifyLoginData extends Login {

    private VerifyLoginDataInterface verifyLoginData;

    /**
     * Creates a new VerifyLoginData instance with the specified login credentials and verification interface.
     *
     * @param username The username of the user trying to log in.
     * @param password The password of the user trying to log in.
     * @param email The email of the user trying to log in.
     * @param verifyLoginData The implementation of VerifyLoginDataInterface to use for data verification.
     */
    public VerifyLoginData(String username, String password, String email, VerifyLoginDataInterface verifyLoginData) {
        super(username, password, email);
        this.verifyLoginData = verifyLoginData;
    }

    /**
     * Verifies the user login data using the implementation of VerifyLoginDataInterface.
     *
     * @return true if the user login data is valid, false otherwise.
     */
    public boolean verifyData() {
        User user = super.getUser();
        return this.verifyLoginData.verifyUserProvidedData(user.getUsername(), user.getPassword());
    }

    /**
     * Retrieve a users' data.
     *
     * @return Retrieve a users' data.
     */
    @Override
    public HashMap<String, Object> getUsersDataMap() {
        return null;
    }
}
