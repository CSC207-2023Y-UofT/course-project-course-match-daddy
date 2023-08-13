package com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Program;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Survey;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.course_subclasses.ArtsAndSciencesCourse;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.program_subclasses.Type1Program;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.survey_subclasses.UserData;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.user_subclasses.LoggedInUser;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.updatesettings_subclasses.SaveSurveyData;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.login_class_imports_implementations.CreateUserAccountInterface;


import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UpdateSettingsTest extends TestCase {

    private static final String USERNAME = "testUser";
    private static final String PASSWORD = "testPassword";
    private static final String EMAIL = "test@example.com";


    public void testUpdateSettings() {
        //all variables needed to construct the objects
        float numCredits = (float) 3.0;
        List<String> coursesTaken = new ArrayList<>();
        HashMap<String, String> completeData = new HashMap<>();
        coursesTaken.add("ISP100");
        User userData = new LoggedInUser(USERNAME, EMAIL, PASSWORD);

        //Creating use case instance
        SaveSurveyData settingsUpdate = new SaveSurveyData(userData);

        //Creates mock interface for the database
        CreateUserAccountInterfaceMock db = new CreateUserAccountInterfaceMock();

        //variables for construction of survey object
        String newUsername = "newUser";
        String newEmail = "newemail@gmail.com";
        String newPassword = "newPassword";
        String newProgram = "Mathematics";

        //Information needed to call the tested method
        Map<String, Course> selectedCourses = new HashMap<>();
        Course tempCourse = new ArtsAndSciencesCourse("Writing", "ISP100", "Good", "/", new HashMap<>() );
        selectedCourses.put(tempCourse.getCourseTitle(), tempCourse);

        Map<String, Program> selectedPrograms = new HashMap<>();
        Program tempProgram = new Type1Program("English", "ENG", "good", "Nothing");
        selectedPrograms.put(tempProgram.getProgramTitle(), tempProgram);

        //Creates the survey object (UserData)
        Survey surveyInfo = new UserData(newUsername, newEmail, newPassword, newProgram, numCredits, coursesTaken, completeData);

        //Stores if method call is successful
        boolean success = settingsUpdate.updateSettings(newUsername, newEmail, newPassword, selectedCourses, selectedPrograms, surveyInfo, db);

        //Checks changes made
        assertEquals(userData.getEmail(), newEmail);
        assertEquals(userData.getUserSurveyData(), surveyInfo);
        assertEquals(userData.getUsername(), newUsername);
        assertEquals(userData.getPassword(), newPassword);
        assertEquals(userData.getSelectedCourses(), selectedCourses);
        assertEquals(userData.getSelectedPrograms(), selectedPrograms);
        assertTrue(success);
    }

    // Mock implementation of CreateUserAccountInterface for testing
    private static class CreateUserAccountInterfaceMock implements CreateUserAccountInterface {

        @Override
        public boolean updateUserData(User userData) {
            return true;//For testing purposes
        }

        @Override
        public boolean verifyUser(User user) {
            return true;//For testing purposes
        }

        @Override
        public boolean removeUser(User user) {
            return true;//For testing purposes
        }
    }

}