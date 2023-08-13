package com.example.coursematchdaddy.clean_architecture_layers.presenters.classes;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Survey;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.updatesettings_class_imports_implementations.ViewSettingsDataInterface;

import java.util.HashMap;
import java.util.Objects;

//Don't think <getUserData> is a necessary method
public class SettingsPresenter implements ViewSettingsDataInterface {

    public SettingsPresenter() {
    }

    /**
     * Returns all of user data needed for settings
     * @param userData the user object of which the data is needed
     * @return HashMap<String, Object>
     */
    public HashMap<String, Object> getUserData(User userData) {

        //Represents all of the user data as a hashmap
        HashMap<String, Object> data = new HashMap<>();

        data.put("username", userData.getUsername());
        data.put("password", userData.getPassword());
        data.put("email", userData.getEmail());

        //Saves survey data of the user
        Survey surveyData = userData.getUserSurveyData();

        data.put("program", surveyData.getProgram());
        data.put("numOfCredits", surveyData.getNumCredits());
        data.put("courses", surveyData.getCoursesTaken());
        data.put("preferences", surveyData.getCompleteData());

        return data;

    }

    /**
     * Return whether the user filled in all input boxes, and correctly
     *
     * @param inputFields username entered, email entered, password entered, program of study entered
     * number of credits entered
     * @return boolean on whether the information they returned is valid or not
     */

    public boolean validateInfo(HashMap<String, String> inputFields) {
        return !Objects.equals(inputFields.get("programOfStudy"), "") &&
                !Objects.equals(inputFields.get("numOfCredits"), "");
    }
}
