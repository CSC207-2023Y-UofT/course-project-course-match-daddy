package com.example.coursematchdaddy.clean_architecture_layers.gateways.classes;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Program;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Survey;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.user_subclasses.LoggedInUser;

import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.login_class_imports_implementations.CreateUserAccountInterface;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.login_class_imports_implementations.ExtractUserDataInterface;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.login_class_imports_implementations.VerifyLoginDataInterface;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.recommendationalgorithm_class_imports_implementations.ExtractCoursesRecommendationsInterface;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.recommendationalgorithm_class_imports_implementations.ExtractProgramsRecommendationsInterface;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.swipecarousel_class_imports_implementations.SwipeCardLeftInterface;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.swipecarousel_class_imports_implementations.SwipeCardRightInterface;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.updatesettings_class_imports_implementations.SaveSurveyDataInterface;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.updatesettings_class_imports_implementations.UpdateSettingsDataInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Reads and writes user data to the database.
public class DBUsersGateway implements CreateUserAccountInterface, VerifyLoginDataInterface, SwipeCardRightInterface, SwipeCardLeftInterface, ExtractUserDataInterface, ExtractCoursesRecommendationsInterface, ExtractProgramsRecommendationsInterface, SaveSurveyDataInterface, UpdateSettingsDataInterface {
    // Define the private attributes for an instance of the User class.
    private String username; // This is a unique identifier for an instance of the User class.
    private String email; // This is a unique identifier for an instance of the User class.
    private String password;
    private Map<String, Course> selectedCourses= new HashMap<>();;
    private Map<String, Program> selectedPrograms= new HashMap<>();;

    // Survey-related attributes
    private String program = new String();
    private Float numCredits = (float) 0;
    private ArrayList<String> coursesTaken = new ArrayList<String>();
    private ArrayList<String> preferences = new ArrayList<String>();
    private Survey userSurvey;

    // Define a map for storing all of the users in the text file.
    public Map<String, User> usersMap = new HashMap<String, User>();

    /**
     * Reads and writes data from and to a database, respectively.
     */
    public DBUsersGateway(){
        // Load users' data from the database and store it in a User object.
        //[insert database connection here]

        // For the MVP version of this application, each user is stored in a row on a text file.
        // The text file has the following columns: username, email, password, selectedCourses,
        // selectedPrograms, program, numCredits, coursesTaken, and  preferences.

        //[for each user in the text file]:
            //username = [read username];
            //email = [read email];
            //selectedCourses = [read selected courses];
            //selectedPrograms = [read selected programs];
            //program = [read enrolled program];
            //numCredits = [read number of credits];
            //coursesTaken = [read courses taken];
            //preferences = [read preferences];
            // Initialize an instance of the UserData subclass of the Survey class
            //userSurvey = new UserData(username, email, password, program, numCredits, coursesTaken, preferences);

            User userData = new LoggedInUser(username, email, password);
            userData.updateUserSelectedCourses(selectedCourses);
            userData.updateUserSelectedPrograms(selectedPrograms);
            userData.updateUserSurveyData(userSurvey);

            // Add the user to the usersMap
            usersMap.put(username, userData);
    }

    // These next set of interface methods revolve around verifying a user and modifying the user's data.
    /**
     * Verifies the user's provided log in credentials.
     *
     * @param usersMap The maps of user objects containing the users' data.
     * @return true if the username is valid and matches an existing user account, false otherwise.
     */
    public boolean verifyUserProvidedData(HashMap<String, User> usersMap, String providedUsername, String providedEmail, String providedPassword){
        if (usersMap.containsKey(username)) {
            if (usersMap.get((string) username).getEmail().equals(providedEmail) && usersMap.get((string) username).getPassword().equals(providedPassword)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Retrieve a user's data.
     *
     * @param username This is a unique identifier for a user.
     * @return
     */
    @Override
    public User getUserData(String username) {
        if (usersMap.containsKey(username)) {
            return usersMap.get((string) username);
        }
        return null;
    }

    /**
     * Add or update a user within the text file.
     *
     * @param userData This is the provided user's data.
     * @return Return true if this operation is successful.
     */
    @Override
    public boolean updateUserData(User userData) {
        if (usersMap.containsKey(username)) {
            usersMap.get((string) username) = userData;
            //[update the corresponding row within the text file];
            return true;
        }
        usersMap.put(userData.username, userData);
        //[update the corresponding row within the text file];
        return true;
    }
}
