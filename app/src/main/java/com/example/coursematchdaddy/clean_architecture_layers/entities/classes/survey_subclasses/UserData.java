package com.example.coursematchdaddy.clean_architecture_layers.entities.classes.survey_subclasses;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Survey;
import com.example.coursematchdaddy.clean_architecture_layers.entities.interfaces.survey_class_imports_implementations.UserDataInterface;

import java.util.ArrayList;
import java.util.HashMap;

public class UserData extends Survey implements UserDataInterface {

    public UserData(String program, Integer numCredits, ArrayList<String> courses, ArrayList<String> preferences) {
        super(program, numCredits, courses, preferences);


    }

    public HashMap<String, Object> getUserSurveyData() {
        HashMap<String, Object> data = new HashMap<>();

        data.put("program", getProgram());
        data.put("numOfCredits", getNumCredits());
        data.put("courses", getCourses());
        data.put("preferences", getPreferences());
        return data;
    }

    
}
