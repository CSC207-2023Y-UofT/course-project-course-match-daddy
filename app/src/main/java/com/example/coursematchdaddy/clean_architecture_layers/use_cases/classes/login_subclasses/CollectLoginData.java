
package com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.login_subclasses;

import com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.Login;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.login_class_imports_implementations.CollectLoginDataInterface;

import java.util.HashMap;

public class CollectLoginData extends Login {

    private CollectLoginDataInterface collectLoginData;

    /**
     * Creates a new CollectLoginData instance with the provided login credentials and data collection interface.
     *
     * @param username The username of the user whose login data needs to be collected and stored.
     * @param password The password of the user whose login data needs to be collected and stored.
     * @param email The email of the user whose login data needs to be collected and stored.
     * @param collectLoginData The implementation of CollectLoginDataInterface to use for data collection and storage.
     */
    public CollectLoginData(String username, String password, String email, CollectLoginDataInterface collectLoginData) {
        super(username, password, email);
        this.collectLoginData = collectLoginData;
    }

    /**
     * Collects user login data and stores it using the implementation of CollectLoginDataInterface.
     * It stores the user's email, password, and username in the desired persistence.
     */
    public void storeData() {
        this.collectLoginData.storeEmail(super.getEmail());
        this.collectLoginData.storePassword(super.getPassword());
        this.collectLoginData.storeUsername(super.getUsername());
    }

    @Override
    public HashMap<String, Object> getUsersDataMap() {
        return null;
    }
}
