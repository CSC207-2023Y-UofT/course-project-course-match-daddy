package com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.updatesettings_class_imports_implementations;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Survey;

public interface SaveSurveyDataInterface {

    /**
     * Saves the survey information and returns a boolean
     * @param survey
     * @return
     */
    Boolean saveSurvey(Survey survey);
}
