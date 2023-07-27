package com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.updatesettings_subclasses;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.UpdateSettings;

import java.util.HashMap;

public class UpdateSettingsData extends UpdateSettings {
    /**
     * Constructor method for the UpdateSettings class.
     *
     * @param userData A user's updated data.
     */
    public UpdateSettingsData(User userData) {
        super(userData);
    }

    /**
     * return the User's survey data
     *
     * @return The User's survey data a HashMap
     */
    @Override
    public HashMap<String, Object> getGenericSurveyData() {
        return null;
    }

    /**
     * Get Survey data from the User
     *
     * @return A HashMap containing the survey data the user submitted
     */
    @Override
    public HashMap<String, Object> getUserSurveyData() {
        return null;
    }

    /**
     * Get the username of the User
     *
     * @return a String representing the username
     */
    @Override
    public String getUsername() {
        return null;
    }

    /**
     * Get the User's password
     *
     * @return a String representing the user's password
     */
    @Override
    public String getPassword() {
        return null;
    }

    /**
     * Get the User's email
     *
     * @return a String representing the User's email
     */
    @Override
    public String getEmail() {
        return null;
    }

    /**
     * Sets the User's password to the new password
     *
     * @param password
     */
    @Override
    public void setPassword(String password) {

    }

    /**
     * Sets the User's username to the new username
     *
     * @param username
     */
    @Override
    public void setUsername(String username) {

    }

    /**
     * Sets the User's email to the new email
     *
     * @param email
     */
    @Override
    public void setEmail(String email) {

    }
}
