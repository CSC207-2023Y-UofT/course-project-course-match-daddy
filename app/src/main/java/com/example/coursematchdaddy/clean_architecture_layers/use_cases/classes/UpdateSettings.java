package com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Program;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Survey;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.entities.interfaces.survey_class_imports_implementations.GenericDataInterface;
import com.example.coursematchdaddy.clean_architecture_layers.entities.interfaces.survey_class_imports_implementations.UserDataInterface;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.login_class_imports_implementations.CreateUserAccountInterface;

import java.util.Map;

// Handles a user’s data and related methods.
public abstract class UpdateSettings implements UserDataInterface, GenericDataInterface {
    // Define the private attributes for an instance of the UpdateSettings class.
    private final User userData;

    // Define the private attributes for an instance of the UpdateSettings class.

    /**
     * Constructor method for the UpdateSettings class.
     *
     * @param userData A user's updated data.
     */
    public UpdateSettings(User userData){
        this.userData = userData;
    }

    /**
     * Update a user's settings.
     *
     * @param username This is a user's updated username.
     * @param email This is a user's updated email.
     * @param password This is a user's updated password.
     * @param selectedCourses This is a user's updated selected courses.
     * @param selectedPrograms This is a user's updated selected programs.
     * @param userSurvey This is a user's updated survey data.
     * @param db Persistence used to save the changes to internal storage
     * @return Return true if update is successful.
     */
    //TODO: Consider making multiple "update" methods in order to avoid having so many parameters.
    public boolean updateSettings(String username, String email, String password, Map<String, Course> selectedCourses, Map<String, Program> selectedPrograms, Survey userSurvey, CreateUserAccountInterface db){
        // Update a user's attributes.
        boolean successful;
        userData.updateUsername(username);
        userData.updateUserEmail(email);
        userData.updateUserPassword(password);
        userData.updateUserSelectedCourses(selectedCourses);
        userData.updateUserSelectedPrograms(selectedPrograms);
        userData.updateUserSurveyData(userSurvey);
        successful = db.updateUserData(userData);
        return successful;
    }
}
