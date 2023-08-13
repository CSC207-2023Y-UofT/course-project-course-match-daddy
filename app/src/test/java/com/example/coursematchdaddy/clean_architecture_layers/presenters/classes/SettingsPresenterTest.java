package com.example.coursematchdaddy.clean_architecture_layers.presenters.classes;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Survey;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.survey_subclasses.UserData;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.user_subclasses.LoggedInUser;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/** @noinspection ALL*/
public class SettingsPresenterTest extends TestCase {
    private static final String USERNAME = "testUser";
    private static final String PASSWORD = "testPassword";
    private static final String EMAIL = "test@example.com";

    public void testGetUserData() {
        //Create and instance of SettingPresenter for testing
        SettingsPresenter presenter = new SettingsPresenter();

        //Create User object for the method
        User user = new LoggedInUser(USERNAME, EMAIL, PASSWORD);

        //Create Survey object for the user
        String program = "Computer Science";
        Float numOfCredits = (float) 3.0;
        List courses = new ArrayList();
        HashMap completeData = new HashMap();

        Survey survey = new UserData(USERNAME, EMAIL, PASSWORD, program, numOfCredits, courses, completeData);

        //Updating user object with tne new survey
        user.updateUserSurveyData(survey);

        //Call the method
        HashMap<String, Object> data = presenter.getUserData(user);

        //Check
        assertEquals(USERNAME, data.get("username"));
        assertEquals(EMAIL, data.get("email"));
        assertEquals(PASSWORD, data.get("password"));
        assertEquals(program, data.get("program"));
        assertEquals(courses, data.get("courses"));
        assertEquals(completeData, data.get("preferences"));

    }

    public void testValidateInfo() {
        //Create and instance of SettingPresenter for testing
        SettingsPresenter presenter = new SettingsPresenter();

        //Create InputFielf for the arguments of the method call
        HashMap<String, String> inputField = new HashMap<>();
        inputField.put("numOfCredits", "3.0");
        inputField.put("programOfStudy", "Computer Science");

        //Calling the method
        Boolean success = presenter.validateInfo(inputField);

        assertTrue(success);
    }
}