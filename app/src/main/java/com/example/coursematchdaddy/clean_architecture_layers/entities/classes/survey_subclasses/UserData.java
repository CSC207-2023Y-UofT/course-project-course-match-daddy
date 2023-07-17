package com.example.coursematchdaddy.clean_architecture_layers.entities.classes.survey_subclasses;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Survey;
import com.example.coursematchdaddy.clean_architecture_layers.entities.interfaces.survey_class_imports_implementations.UserDataInterface;

import java.util.ArrayList;
import java.util.HashMap;

public class UserData extends Survey implements UserDataInterface {

    private String username;
    private String email;
    private String password;

    public UserData(String username, String email, String password, String program, Integer numCredits, ArrayList<String> courses, ArrayList<String> preferences) {
        super(program, numCredits, courses, preferences);

        this.username = username;
        this.email = email;
        this.password = password;

    }

    public HashMap<String, Object> getUserSurveyData() {
        HashMap<String, Object> data = new HashMap<>();

        data.put("program", getProgram());
        data.put("numOfCredits", getNumCredits());
        data.put("courses", getCourses());
        data.put("preferences", getPreferences());
        return data;
    }

    public String getUsername() {
        return this.username;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String value) {
        this.password =  value;
    }

    public void setUsername(String value) {
        this.username = value;
    }

    public void setEmail(String value) {
        this.email = value;
    }

}
