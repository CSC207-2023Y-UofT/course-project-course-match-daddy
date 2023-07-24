
package com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.login_subclasses;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Survey;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.Login;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.login_class_imports_implementations.ExtractUserDataInterface;

import java.util.HashMap;

public class ExtractUserData extends Login {

    private ExtractUserDataInterface extractUserData;

    /**
     * Creates a new ExtractUserData instance with the provided login credentials and user data extraction interface.
     *
     * @param username The username of the user whose data needs to be extracted.
     * @param password The password of the user whose data needs to be extracted.
     * @param email The email of the user whose data needs to be extracted.
     * @param extractUserData The implementation of ExtractUserDataInterface to use for data extraction.
     */
    public ExtractUserData(String username, String password, String email, ExtractUserDataInterface extractUserData) {
        super(username, password, email);
        this.extractUserData = extractUserData;
    }

    /**
     * Retrieves the user data by using the implementation of ExtractUserDataInterface.
     *
     * @return A HashMap containing the extracted user data with appropriate keys.
     */
    @Override
    public HashMap<String, Object> getUserData() {
        // I assume the class that implements <extractUserData>
        // Will extract the user data from some sort of persistence
        Survey survey = this.extractUserData.getSurveyData(super.getUser());
        String password = this.extractUserData.getPassword(super.getUser());
        String userName = this.extractUserData.getUsername(super.getUser());
        String email = this.extractUserData.getEmail(super.getUser());

        HashMap<String, Object> userData = new HashMap<>();
        userData.put("survey", survey);
        userData.put("password", password);
        userData.put("username", userName);
        userData.put("email", email);

        return userData;
    }
}
