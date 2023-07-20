package com.example.coursematchdaddy.clean_architecture_layers.entities.classes.survey_subclasses;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Survey;
import com.example.coursematchdaddy.clean_architecture_layers.entities.interfaces.survey_class_imports_implementations.GenericDataInterface;

import java.util.ArrayList;
import java.util.HashMap;

public class GenericData extends Survey implements GenericDataInterface {


    /**
     * creates data for guest user
     * @param program
     * @param numCredits
     * @param courses
     * @param preferences
     */
    public GenericData(String program, Float numCredits, ArrayList<String> courses, ArrayList<String> preferences) {
        super(program, numCredits, courses, preferences);

    }

    /**
     * return survey data
     * @return HashMap of user's survey data
     */
    public HashMap<String, Object> getGenericSurveyData() {
        HashMap<String, Object> data = new HashMap<>();

        data.put("program", getProgram());
        data.put("numOfCredits", getNumCredits());
        data.put("courses", getCourses());
        data.put("preferences", getPreferences());
        return data;
    }
}
