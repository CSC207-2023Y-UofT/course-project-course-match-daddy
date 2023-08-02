package com.example.coursematchdaddy.clean_architecture_layers.controllers.classes;

import android.util.Log;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Program;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Survey;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.survey_subclasses.GenericData;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.user_subclasses.LoggedInUser;
import com.example.coursematchdaddy.clean_architecture_layers.gateways.classes.UserDB;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.SubmitSurvey;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.UpdateSettings;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.updatesettings_subclasses.SaveSurveyData;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.updatesettings_class_imports_implementations.CollectSettingsDataInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Handles changes to the user’s settings.
public class SettingsController implements CollectSettingsDataInterface {
    // Define the private attributes.
    private User userData;//TODO: Modify this class so that it does not directly deal with users (or UserDB, but uses
    private UserDB db;   // Some sort of use-case to do that instead (to satisfy CA requirements)
    private UpdateSettings saveData;
    private HashMap<String, String> inputfields;
    private SubmitSurvey submitData;
    /**
     * Retrieves data from the settings view.
     *
     * @param username This is the username of a user; this is a unique identifier for the user.
     */
    public SettingsController(String username, HashMap<String, String> inputfields){
        this.db = new UserDB();
        this.userData = db.getUserFromDB(username);
        this.saveData = new SaveSurveyData(userData);
        this.inputfields = inputfields;
        this.submitData = new SubmitSurvey(this.userData, this.inputfields);
    }

    /**
     * Retrieves and processes a user's provided data from the settings view.
     * This method collects the user's input data, validates the changes, and updates the user's profile if the changes are valid.
     *
     * @return True if the data was successfully collected and the user's profile was updated, false otherwise.
     */
    public boolean collectSettingsData() {
        String username;
        String password;
        String email;
        
        // Leaving a section blank means that the user wants to keep the current username/email.
        boolean changedUsername = !this.inputfields.get("username").equals("");
        boolean changedEmail = !this.inputfields.get("email").equals("");
        boolean changedPassword = !this.inputfields.get("password").equals("");

        // Update email from input field if it was changed. If not, use the user object's email.
        if (changedEmail) {
            email = inputfields.get("email");
        } else {
            email = this.userData.getEmail();
        }

        // Update username from input field if it was changed. If not, use the user object's username.
        if (changedUsername) {
            username = inputfields.get("username");
        } else {
            username = this.userData.getUsername();
        }

        // Update password from the input field if it was changed. If not, use the user object's password.
        if (changedPassword) {
            password = inputfields.get("password");
        } else {
            password = this.userData.getPassword();
        }

        // Check if changes were valid before finalizing them.
        if ((!changedEmail || this.db.checkEmailUniqueness(email)) && (!changedUsername || this.db.checkUsernameUniqueness(username))) {
            Survey surveyData = createSurveyData();
            return updateUserData(username, email, password, surveyData);
        } else {
            return false;
        }
    }

    /**
     * Creates a Survey object from the user's input data.
     *
     * @return The Survey object created from the user's input data.
     */
    private Survey createSurveyData() {
        ArrayList<String> coursesTaken = new ArrayList<>();
        for (String s : this.inputfields.get("coursesTaken").split(" ")) {
            coursesTaken.add(s.toUpperCase());
            // TODO: add better parsing if needed
        }

        float numCredits = 0.0f;
        try {
            numCredits = Float.parseFloat(this.inputfields.get("numOfCredits"));
        } catch (NumberFormatException e) {
            // Default to 0 if the user provides bad input
            numCredits = 0.0f;
        }

        String program = this.inputfields.get("programOfStudy").toUpperCase();
        return new GenericData(program, numCredits, coursesTaken, this.inputfields);
    }

    /**
     * Updates the user's profile with the provided data.
     *
     * @param username        The updated username.
     * @param email           The updated email.
     * @param password        The updated password.
     * @param surveyData      The survey data to update the user's profile.
     * @return True if the user's profile was successfully updated, false otherwise.
     */
    private boolean updateUserData(String username, String email, String password, Survey surveyData) {
        SaveSurveyData saveData = new SaveSurveyData(this.userData);
        return db.removeUser(this.userData) && saveData.updateSettings(username, email, password, this.userData.getSelectedCourses(), this.userData.getSelectedPrograms(), surveyData, db);
    }


    @Override
    public boolean collectSettingsData(User userData) {
        return false;
    }
}
