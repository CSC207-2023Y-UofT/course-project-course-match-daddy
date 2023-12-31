package com.example.coursematchdaddy.clean_architecture_layers.entities.classes;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.survey_subclasses.UserData;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Creates a user’s account, stores information about the user, and modifies user data.
public abstract class User implements Serializable {
    // Define the private attributes for an instance of the User class.
    private String email; // This is a unique identifier for an instance of the User class.
    private String password;
    private Map<String, Course> selectedCourses= new HashMap<>();
    private Map<String, Program> selectedPrograms= new HashMap<>();

    // Survey-related attributes
    private String program = "";
    private Float numCredits = (float) 0;
    private Survey userSurvey;

    // Define the public attributes for an instance of the User class.
    public String username; // This is a unique identifier for an instance of the User class.

    /**
     * Constructor method for an instance of the User class.
     *
     * @param username This is the username of a user; this is a unique identifier for the user.
     * @param email This is the email of a user; this is a unique identifier for the user.
     * @param password This is the password of a user.
     */
    public User(String username, String email, String password) {
        // Initialize the private attributes.
        this.email = email;
        this.password = password;

        // Initialize the public attributes.
        this.username = username;

        // Initialize an instance of the UserData subclass of the Survey class
        List<String> coursesTaken = new ArrayList<>();
        HashMap<String, String> preferences = new HashMap<>();
        userSurvey = new UserData(username, email, password, program, numCredits, coursesTaken, preferences);
    }

    /**
     * Retrieve a user's username.
     *
     * @return Return a user's username.
     */
    public String getUsername(){ return this.username; }

    /**
     * Retrieve a user's email.
     *
     * @return Return a user's email.
     */
    public String getEmail(){ return this.email; }

    /**
     * Retrieve a user's password.
     *
     * @return Return a user's password.
     */
    public String getPassword(){ return this.password; }

    /**
     * Retrieve a user's program of study.
     * 
     * @return Return a user's program of study.
     */
    public String getProgram() { return this.program; }

    /**
     * Retrieve a user's number of course credits completed.
     * 
     * @return Return a user's number of course credits completed.
     */
    public float getNumCredits() { return this.numCredits; }

    /**
     * Retrieve a user's selected courses.
     *
     * @return Return a user's selected courses.
     */
    public Map<String, Course> getSelectedCourses() { return this.selectedCourses; }

    /**
     * Retrieve a user's selected programs.
     *
     * @return Return a user's selected programs.
     */
    public Map<String, Program> getSelectedPrograms() { return this.selectedPrograms; }

    /**
     * Retrieve a user's survey data.
     *
     * @return Return a user's survey data.
     */
    public Survey getUserSurveyData(){
        return this.userSurvey;
    }

    /**
     * Update a user's username.
     *
     * @param username A user's username.
     */
    public void updateUsername(String username) {
        // Update the private email variable.
        this.username = username;

    }

    /**
     * Update a user's email.
     *
     * @param email A user's email.
     */
    public void updateUserEmail(String email) {
        // Update the private email variable.
        this.email = email;

    }

    /**
     * Update a user's password.
     *
     * @param password A user's password.
     */
    public void updateUserPassword(String password) {
        // Update the private password variable.
        this.password = password;

    }

    /**
     * Update user's program of study.
     *
     * @param program A user's program of study.
     */
    public void updateProgram(String program) {
        // Update the private program variable.
        this.program = program;

    }

    /**
     * Update a user's number of course credits completed.
     *
     * @param numCredits A user's number of course credits completed.
     */
    public void updateNumCredits(float numCredits) {
        // Update the private numCredits variable.
        this.numCredits = numCredits;

    }

    /**
     * Update a user's selected courses.
     *
     * @param selectedCourses A user's selected courses.
     */
    public void updateUserSelectedCourses(Map<String, Course> selectedCourses) {
        // Update the private selectedCourses variable.
        this.selectedCourses = selectedCourses;

    }

    /**
     * Update a user's selected programs.
     *
     * @param selectedPrograms A user's selected programs.
     */
    public void updateUserSelectedPrograms(Map<String, Program> selectedPrograms) {
        // Update the private selectedPrograms variable.
        this.selectedPrograms = selectedPrograms;

    }

    /**
     * Update a user's survey data.
     *
     * @param userSurvey A user's survey data.
     */
    public void updateUserSurveyData(Survey userSurvey) {
        // Update the private userSurvey variable.
        this.userSurvey = userSurvey;

    }
}
