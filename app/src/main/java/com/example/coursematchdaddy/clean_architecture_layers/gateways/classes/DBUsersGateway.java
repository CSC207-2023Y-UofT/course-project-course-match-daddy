package com.example.coursematchdaddy.clean_architecture_layers.gateways.classes;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.login_class_imports_implementations.CreateUserAccountInterface;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.login_class_imports_implementations.ExtractUserDataInterface;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.login_class_imports_implementations.VerifyLoginDataInterface;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.recommendationalgorithm_class_imports_implementations.ExtractCoursesRecommendationsInterface;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.recommendationalgorithm_class_imports_implementations.ExtractProgramsRecommendationsInterface;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.swipecarousel_class_imports_implementations.SwipeCardLeftInterface;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.swipecarousel_class_imports_implementations.SwipeCardRightInterface;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.updatesettings_class_imports_implementations.SaveSurveyDataInterface;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.updatesettings_class_imports_implementations.UpdateSettingsDataInterface;

public class DBUsersGateway implements CreateUserAccountInterface, VerifyLoginDataInterface, SwipeCardRightInterface,
        SwipeCardLeftInterface, ExtractUserDataInterface, ExtractCoursesRecommendationsInterface,
        ExtractProgramsRecommendationsInterface, SaveSurveyDataInterface, UpdateSettingsDataInterface {

  /**
  IMPORTANT:
    I'm assuming that the <getUsername> method will be implemented here as per the design doc
    Also note, <username> is listed as a public attribute of User on the design doc which
    Is why im not using a getter for it. I also assume that the "get" methods in this class
     will somehow access whatever persistence we choose to use to fetch the needed data. Please
     correct me if I am misunderstanding anything
     **/
    
    /**
     * Verifies the correctness of the provided username in the user data.
     *
     * @param userData The User object containing the user data, including the username to be verified.
     * @return true if the username is valid and matches an existing user account, false otherwise.
     */
    public boolean verifyUsername(User userData){
        if (userData.username.equals(getUsername(userData))){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Verifies the correctness of the provided password in the user data.
     *
     * @param userData The User object containing the user data, including the password to be verified.
     * @return true if the password is valid and matches the corresponding user's password, false otherwise.
     */
    public boolean verifyPassword(User userData){
        if (userData.getPassword().equals(getPassword(userData))){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Verifies the correctness of the provided email in the user data.
     *
     * @param userData The User object containing the user data, including the email to be verified.
     * @return true if the email is valid and matches an existing user account, false otherwise.
     */
    public boolean verifyEmail(User userData){
        if (userData.getEmail().equals(getEmail(userData))){
            return true;
        } else {
            return false;
        }
    }
}
