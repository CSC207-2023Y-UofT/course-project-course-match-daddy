package com.example.coursematchdaddy.clean_architecture_layers.entities.interfaces.survey_class_imports_implementations;

import java.util.HashMap;

public interface UserDataInterface {
    HashMap<String, Object> getUserSurveyData();

    String getUsername();

    String getPassword();

    String getEmail();

    String setPassword();

    String setUsername();

    String setEmail();
}
