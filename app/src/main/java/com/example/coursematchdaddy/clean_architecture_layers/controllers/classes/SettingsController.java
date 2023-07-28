package com.example.coursematchdaddy.clean_architecture_layers.controllers.classes;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Program;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Survey;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.user_subclasses.LoggedInUser;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.updatesettings_class_imports_implementations.CollectSettingsDataInterface;

import java.util.HashMap;

// Handles changes to the user’s settings.
public abstract class SettingsController implements CollectSettingsDataInterface {
    // Define the private attributes.
    private User userData;

    /**
     * Retrieves data from the settings view.
     *
     * @param username This is the username of a user; this is a unique identifier for the user.
     * @param email This is the email of a user; this is a unique identifier for the user.
     * @param password This is the password of a user.
     * @param selectedCourses This is the collection of a user's selected courses.
     * @param selectedPrograms This is the collection of a user's selected programs.
     * @param userSurvey This is the user's survey data.
     */
    public SettingsController(String username, String email, String password, HashMap<String, Course> selectedCourses, HashMap<String, Program> selectedPrograms, Survey userSurvey){
        userData = new LoggedInUser(username, email, password);
        userData.updateUserSelectedCourses(selectedCourses);
        userData.updateUserSelectedPrograms(selectedPrograms);
        userData.updateUserSurveyData(userSurvey);

        collectSettingsData(userData);
    }

    /**
     * Retrieve a user's provided data from the settings view.
     *
     * @param userData This is an instance of a User class.
     * @return Return true if the data was successfully collected.
     */
    @Override
    public boolean collectSettingsData(User userData) {
        return true;
    }
}
