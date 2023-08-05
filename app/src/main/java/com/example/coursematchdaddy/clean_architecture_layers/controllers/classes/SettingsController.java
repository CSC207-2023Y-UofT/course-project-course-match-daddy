package com.example.coursematchdaddy.clean_architecture_layers.controllers.classes;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Survey;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.gateways.classes.UserDB;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.SubmitSurvey;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.UpdateSettings;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.updatesettings_subclasses.SaveSurveyData;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.updatesettings_class_imports_implementations.CollectSettingsDataInterface;

import java.util.ArrayList;
import java.util.HashMap;

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
     * Retrieve a user's provided data from the settings view.
     *
     * @return Return true if the data was successfully collected.
     */
    @Override
    public boolean collectSettingsData() {
        String username;
        String password;
        String email;
        //TODO: Check for potential bugs
        // Leaving section blank means that they want the username/email to stay the same.
        boolean changedUsername = !this.inputfields.get("username").equals("");
        boolean changedEmail = !this.inputfields.get("email").equals("");
        boolean changedPassword = !this.inputfields.get("password").equals("");

        //Update email from input field if it was changed. If not, use user object
        if (changedEmail){
            email = inputfields.get("email");
        }else{
            email = this.userData.getEmail();
        }
        //Update username from input field if it was changed. If not, use user object
        if (changedUsername){
            username = inputfields.get("username");
        }else{
            username = this.userData.getUsername();
        }
        //Update password from input field if it was changed. If not, use user object
        if (changedPassword){
            password = inputfields.get("password");
        }else{
            password = this.userData.getPassword();
        }
        //check if changes were valid before finalizing them.
        if ((!changedEmail | this.db.checkEmailUniqueness(email)) && (!changedUsername | this.db.checkUsernameUniqueness(username))){
            saveData = new SaveSurveyData(this.userData);
            ArrayList<String> coursestaken = new ArrayList<>();
            for (String s: this.inputfields.get("coursesTaken").split(" ")){
                coursestaken.add(s.toUpperCase());
                //TODO: add better parsing
            }
            float numCredits = 0.0f;
            try {
                numCredits = Float.parseFloat(this.inputfields.get("numOfCredits"));
            } catch (NumberFormatException e) {
                //Default to 0 if user provides bad input
                numCredits = 0.0f;
            }
            db.removeUser(this.userData);//remove user from database
            String program = this.inputfields.get("programOfStudy").toUpperCase();
            Survey surveyData = submitData.userSubmit(username, email,password,program,numCredits,coursestaken,this.inputfields);
            //TODO: Ensure that saveData also saves the resulting user object in the UserDB
            //Save user data and then save it under a new "key" in the databse (remember, username is unique identifier)
            return saveData.updateSettings(username, email, password, this.userData.getSelectedCourses(), this.userData.getSelectedPrograms(), surveyData, this.db) && db.updateDB(this.userData);
        }else{
            return false;
        }

    }

    /**
     * Returns a users username
     *
     * @return Users username
     */
    public String getUsername() {
        return this.userData.getUsername();
    }
}
