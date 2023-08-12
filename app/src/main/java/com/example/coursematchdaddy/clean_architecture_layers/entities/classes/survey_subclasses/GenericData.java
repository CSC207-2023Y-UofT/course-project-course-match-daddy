package com.example.coursematchdaddy.clean_architecture_layers.entities.classes.survey_subclasses;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Survey;
import com.example.coursematchdaddy.clean_architecture_layers.entities.interfaces.survey_class_imports_implementations.GenericDataInterface;

import java.util.ArrayList;
import java.util.HashMap;

public class GenericData extends Survey implements GenericDataInterface {


    /**
     * creates data for guest user
     * @param program the program the user entered
     * @param numCredits the number of credits the user has taken
     * @param courses the user's past courses
     * @param completeData all of the user's given data
     */
    public GenericData(String program, Float numCredits, ArrayList<String> courses, HashMap<String, String> completeData) {
        super(program, numCredits, courses, completeData);

    }

    /**
     * return survey data
     * @return HashMap of user's survey data
     */
    public HashMap<String, Object> getGenericSurveyData() {
        HashMap<String, Object> data = new HashMap<>();

        data.put("program", getProgram());
        data.put("numOfCredits", getNumCredits());
        data.put("courses", super.getCoursesTaken());
        data.put("preferences", getCompleteData());
        return data;
    }
}
