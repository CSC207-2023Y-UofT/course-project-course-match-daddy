
package com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.login_subclasses;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Survey;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.Login;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.login_class_imports_implementations.ExtractUserDataInterface;

import java.util.HashMap;

public class ExtractUserData extends Login {

    private final ExtractUserDataInterface extractUserData;

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
    public HashMap<String, Object> getUserData() {
        User user = extractUserData.getUserData(super.getEmail());
        Survey survey = user.getUserSurveyData();
        String password = user.getPassword();
        String userName = user.getUsername();
        String email = user.getEmail();

        HashMap<String, Object> userData = new HashMap<>();
        userData.put("survey", survey);
        userData.put("password", password);
        userData.put("username", userName);
        userData.put("email", email);

        return userData;
    }
}
