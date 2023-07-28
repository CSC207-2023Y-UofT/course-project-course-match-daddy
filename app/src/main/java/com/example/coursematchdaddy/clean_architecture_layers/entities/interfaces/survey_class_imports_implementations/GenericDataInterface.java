package com.example.coursematchdaddy.clean_architecture_layers.entities.interfaces.survey_class_imports_implementations;

import java.util.HashMap;

public interface GenericDataInterface {

    /**
     * return the User's survey data
     * @return The User's survey data a HashMap
     */
    HashMap<String, Object> getGenericSurveyData();
}
