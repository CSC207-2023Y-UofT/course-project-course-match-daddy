package com.example.coursematchdaddy.clean_architecture_layers.controllers.classes;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Survey;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.SubmitSurvey;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.UpdateSettings;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.updatesettings_subclasses.SaveSurveyData;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.login_class_imports_implementations.CreateUserAccountInterface;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.login_class_imports_implementations.ExtractUserDataInterface;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.login_class_imports_implementations.VerifyLoginDataInterface;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.updatesettings_class_imports_implementations.CollectSettingsDataInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

// Handles changes to the user’s settings.
public class SettingsController implements CollectSettingsDataInterface {
    // Define the private attributes.
    private final User userData;
    private final CreateUserAccountInterface createAccount;
    private UpdateSettings saveData;
    private final HashMap<String, String> inputFields;
    private final SubmitSurvey submitData;
    private final VerifyLoginDataInterface verifyLoginData;
    /**
     * Retrieves data from the settings view.
     *
     * @param username This is the username of a user; this is a unique identifier for the user.
     */
    public SettingsController(String username, HashMap<String, String> inputFields, ExtractUserDataInterface extractUserData, CreateUserAccountInterface createAccount, VerifyLoginDataInterface verifyLoginData){
        this.createAccount = createAccount;
        this.verifyLoginData = verifyLoginData;
        this.userData = extractUserData.getUserFromDB(username);
        this.saveData = new SaveSurveyData(userData);
        this.inputFields = inputFields;
        this.submitData = new SubmitSurvey();
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
        boolean changedUsername = !Objects.equals(this.inputFields.get("username"), "");
        boolean changedEmail = !Objects.equals(this.inputFields.get("email"), "");
        boolean changedPassword = !Objects.equals(this.inputFields.get("password"), "");

        //Update email from input field if it was changed. If not, use user object
        if (changedEmail){
            email = inputFields.get("email");
        }else{
            email = this.userData.getEmail();
        }
        //Update username from input field if it was changed. If not, use user object
        if (changedUsername){
            username = inputFields.get("username");
        }else{
            username = this.userData.getUsername();
        }
        //Update password from input field if it was changed. If not, use user object
        if (changedPassword){
            password = inputFields.get("password");
        }else{
            password = this.userData.getPassword();
        }
        //check if changes were valid before finalizing them.
        if ((!changedEmail | this.verifyLoginData.checkEmailUniqueness(email)) && (!changedUsername | this.verifyLoginData.checkUsernameUniqueness(username))){
            saveData = new SaveSurveyData(this.userData);
            ArrayList<String> coursesTaken = new ArrayList<>();
            for (String s: Objects.requireNonNull(this.inputFields.get("coursesTaken")).split(" ")){
                coursesTaken.add(s.toUpperCase());
                //TODO: add better parsing
            }
            float numCredits;
            try {
                numCredits = Float.parseFloat(Objects.requireNonNull(this.inputFields.get("numOfCredits")));
            } catch (NumberFormatException e) {
                //Default to 0 if user provides bad input
                numCredits = 0.0f;
            }

            this.createAccount.removeUser(this.userData);//remove user from database

            String program = Objects.requireNonNull(this.inputFields.get("programOfStudy")).toUpperCase();
            Survey surveyData = submitData.userSubmit(username, email,password,program,numCredits,coursesTaken,this.inputFields);
            //TODO: Ensure that saveData also saves the resulting user object in the UserDB
            //Save user data and then save it under a new "key" in the database (remember, username is unique identifier)

            return saveData.updateSettings(username, email, password, this.userData.getSelectedCourses(), this.userData.getSelectedPrograms(), surveyData, this.createAccount) && createAccount.updateUserData(this.userData);

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
