package com.example.coursematchdaddy.clean_architecture_layers.entities.interfaces.survey_class_imports_implementations;



import java.util.HashMap;


public interface UserDataInterface {
    /**
     * Get Survey data from the User
     * @return A HashMap containing the survey data the user submitted
     */
    HashMap<String, Object> getUserSurveyData();

    /**
     * Get the username of the User
     * @return a String representing the username
     */
    String getUsername();


    /**
     * Get the User's password
     * @return a String representing the user's password
     */
    String getPassword();

    /**
     * Get the User's email
     * @return a String representing the User's email
     */
    String getEmail();

    /**
     * Sets the User's password to the new password
     * @param password
     */
    void setPassword(String password);

    /**
     * Sets the User's username to the new username
     * @param username
     */
    void setUsername(String username);

    /**
     * Sets the User's email to the new email
     * @param email
     */
    void setEmail(String email);
}
