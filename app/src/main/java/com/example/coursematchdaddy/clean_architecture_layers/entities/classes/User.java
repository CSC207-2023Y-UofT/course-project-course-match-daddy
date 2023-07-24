package com.example.coursematchdaddy.clean_architecture_layers.entities.classes;

import java.util.HashMap;
import java.util.Map;

// Creates a user’s account, stores information about the user, and modifies user data.
public abstract class User {
    // Define the private attributes for an instance of the User class.
    private String email; // This is a unique identifier for an instance of the User class.
    private String password;
    private Map<String, Course> selectedCourses;
    private Map<String, Program> selectedPrograms;
    private Survey userSurvey;

    // Define the public attributes for an instance of the User class.
    public String username; // This is a unique identifier for an instance of the User class.

    /**
     * Constructor method for the User class.
     *
     * @param username This is the username of a user; this is a unique identifier for the user.
     * @param email This is the email of a user; this is a unique identifier for the user.
     * @param password This is the password of a user.
     */
    public User(String username, String email, String password){
        // Initialize the private variables.
        this.email = email;
        this.password = password;
        this.selectedCourses = new HashMap<>();
        this.selectedPrograms = new HashMap<>();
        this.userSurvey = new Survey();

        // Initialize the public variable.
        this.username = username;
    }

    /**
     * Retrieve a user's email.
     *
     * @return Retrieve a user's email.
     */
    public String getEmail(){
        return this.email;
    }

    /**
     * Retrieve a user's selected courses.
     *
     * @return Retrieve a user's selected courses.
     */
    public Map<String, Course> getSelectedCourses(){
        return this.selectedCourses;
    }

    /**
     * Retrieve a user's selected programs.
     *
     * @return Retrieve a user's selected programs.
     */
    public Map<String, Program> getSelectedPrograms(){
        return this.selectedPrograms;
    }

    /**
     * Retrieve a user's survey data.
     *
     * @return Retrieve a user's survey data.
     */
    public Survey getUserSurveyData(){
        return this.userSurvey;
    }

    /**
     * Update a user's email.
     *
     * @param email A user's email.
     * @return Return true if update is successful.
     */
    public boolean updateUserEmail(String email){
        // Update the private email variable.
        this.email = email;

        return true;
    }

    /**
     * Update a user's password.
     *
     * @param password A user's password.
     * @return Return true if update is successful.
     */
    public boolean updateUserPassword(String password){
        // Update the private password variable.
        this.password = password;

        return true;
    }

    /**
     * Update a user's selected courses.
     *
     * @param selectedCourses A user's selected courses.
     * @return Return true if update is successful.
     */
    public boolean updateUserSelectedCourses(Map<String, Course> selectedCourses){
        this.selectedCourses = selectedCourses;

        return true;
    }

    /**
     * Update a user's selected programs.
     *
     * @param selectedPrograms A user's selected programs.
     * @return Return true if update is successful.
     */
    public boolean updateUserSelectedPrograms(Map<String, Program> selectedPrograms){
        this.selectedPrograms = selectedPrograms;

        return true;
    }

    /**
     * Update a user's survey data.
     *
     * @param userSurvey A user's survey data.
     * @return Return true if update is successful.
     */
    public boolean updateUserSurveyData(Survey userSurvey){
        this.userSurvey = userSurvey;

        return true;
    }

    /**
     * Update a user's username.
     *
     * @param username A user's username.
     * @return Return true if update is successful.
     */
    public boolean updateUserUsername(String username){
        // Update the private email variable.
        this.username = username;

        return true;
    }
}
