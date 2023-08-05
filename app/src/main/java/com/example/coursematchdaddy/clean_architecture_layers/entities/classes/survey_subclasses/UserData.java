package com.example.coursematchdaddy.clean_architecture_layers.entities.classes.survey_subclasses;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Survey;
import com.example.coursematchdaddy.clean_architecture_layers.entities.interfaces.survey_class_imports_implementations.UserDataInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//TODO: modify implemented interface. Some of its methods are redundant/not useful/not needed
public class UserData extends Survey implements UserDataInterface {

    private String username;
    private String email;
    private String password;

    /**
     * Stores User data and survey data and returns an instance representing the User's data
     * @param username
     * @param email
     * @param password
     * @param program
     * @param numCredits
     * @param coursesTaken
     * @param completeData
     */
    public UserData(String username, String email, String password,
                    String program, Float numCredits,
                    List<String> coursesTaken, HashMap<String, String> completeData) {
        super(program, Float.valueOf(numCredits), coursesTaken, completeData);

        this.username = username;
        this.email = email;
        this.password = password;

    }

    /**
     * return the survey information the user submitted
     * @return A HashMap of the survey information
     */
    public HashMap<String, Object> getUserSurveyData() {
        HashMap<String, Object> data = new HashMap<>();

        data.put("program", getProgram());
        data.put("numOfCredits", getNumCredits());
        data.put("coursesTaken", getCoursesTaken());
        data.put("preferences", getCompleteData());
        return data;
    }

    /**
     * return the User's username
     * @return String
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * return the User's email
     * @return String
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * return the User's password
     * @return String
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Set the User's password to the new password
     * @param password
     */
    public void setPassword(String password) {
        this.password =  password;
    }

    /**
     * Set the User's username to the new username
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Set the User's email to the new email
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

}
