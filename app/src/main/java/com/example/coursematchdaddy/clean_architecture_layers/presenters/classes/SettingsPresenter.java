package com.example.coursematchdaddy.clean_architecture_layers.presenters.classes;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Survey;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.updatesettings_class_imports_implementations.ViewSettingsDataInterface;

import java.util.HashMap;


public class SettingsPresenter implements ViewSettingsDataInterface {

    public SettingsPresenter() {
    }

    /**
     * Returns all of user data needed for settings
     * @param userData
     * @return HashMap<String, Object>
     */
    public HashMap<String, Object> getUserData(User userData) {

        //Represents all of the user data as a hashmap
        HashMap<String, Object> data = new HashMap<>();

        data.put("email", userData.getEmail());

        //Saves survey data of the user
        Survey surveyData = userData.getUserSurveyData();

        data.put("program", surveyData.getProgram());
        data.put("numOfCredits", surveyData.getNumCredits());
        data.put("courses", surveyData.getCoursesTaken());
        data.put("preferences", surveyData.getPreferences());

        return data;

    }
}
