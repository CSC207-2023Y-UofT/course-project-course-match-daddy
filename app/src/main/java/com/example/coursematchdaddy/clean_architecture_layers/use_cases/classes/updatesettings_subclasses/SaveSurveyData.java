package com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.updatesettings_subclasses;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.UpdateSettings;

import java.util.HashMap;

public class SaveSurveyData extends UpdateSettings {
    /**
     * Constructor method for the UpdateSettings class.
     *
     * @param userData A user's updated data.
     */
    public SaveSurveyData(User userData) {
        super(userData);
    }

}
