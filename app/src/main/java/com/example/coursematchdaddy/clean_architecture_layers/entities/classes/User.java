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
}
