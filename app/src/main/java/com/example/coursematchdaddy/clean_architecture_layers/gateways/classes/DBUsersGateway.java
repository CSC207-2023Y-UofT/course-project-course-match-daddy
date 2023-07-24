package com.example.coursematchdaddy.clean_architecture_layers.gateways.classes;

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

// Reads and writes user data to the database.
public abstract class DBUsersGateway implements CreateUserAccountInterface, VerifyLoginDataInterface, SwipeCardRightInterface, SwipeCardLeftInterface, ExtractUserDataInterface, ExtractCoursesRecommendationsInterface, ExtractProgramsRecommendationsInterface, SaveSurveyDataInterface, UpdateSettingsDataInterface {
    /**
     * Reads and writes data from and to a database, respectively.
     */
    public DBUsersGateway(){
        // Load a user's data from the database and store it in a User object.
        //[insert database connection here]

        //[if the user already exists within the database]
            //String username = [read username]
            //String email = [read email]
            //Map<String, Course> selectedCourses = [read selected courses]
            //Map<String, Program> selectedPrograms = [read selected programs]
            //Survey userSurvey = [read user survey data]

            User userData = new LoggedInUser(username, email, password);
            userData.updateUserSelectedCourses(selectedCourses);
            userData.updateUserSelectedPrograms(selectedPrograms);
            userData.updateUserSurveyData(userSurvey);
        //[else]

    }

    // CreateUserAccountInterface interface implementations
    @Override
    public boolean addUsername(String username) {
        return false;
    }

    @Override
    public boolean addEmail(String email) {
        return false;
    }

    @Override
    public boolean addPassword(String password) {
        return false;
    }



}
