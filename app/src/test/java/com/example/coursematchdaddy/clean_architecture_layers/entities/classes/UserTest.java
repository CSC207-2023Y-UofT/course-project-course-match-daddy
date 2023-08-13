package com.example.coursematchdaddy.clean_architecture_layers.entities.classes;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.survey_subclasses.UserData;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.user_subclasses.LoggedInUser;

import junit.framework.TestCase;

import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class UserTest extends TestCase {
    /**
     * Define a an instance object of the Survey class.
     * @return Return an instance object of the User class.
     */
    public LoggedInUser defineUserObjectInstance() {
        // Define an object instance of the (abstract) Survey class.
        HashMap preferences = new HashMap<String, String>();
        preferences.put("key1", "value1");
        UserData userSurveyData = new UserData("TestUser", "test_user@test.com", "password", "Mathematics", (float) 1, Arrays.asList("CSC207H1"), preferences);

        // Define an object instance of the (abstract) User Class.
        LoggedInUser userData = new LoggedInUser(userSurveyData.getUsername(), userSurveyData.getEmail(), userSurveyData.getPassword());

        // Update the object instance of the (abstract) User class.
        userData.updateProgram(userSurveyData.getProgram());
        userData.updateNumCredits(userSurveyData.getNumCredits());
        userData.updateUserSurveyData(userSurveyData);

        // Update the object instance of the (abstract) User class with selected courses and programs (from the carousel view).
        Map selectedCourses = new HashMap<String, String>();
        selectedCourses.put("course1", "course_metadata1");
        userData.updateUserSelectedCourses(selectedCourses);

        Map selectedPrograms = new HashMap<String, String>();
        selectedPrograms.put("program1", "program_metadata1");
        userData.updateUserSelectedPrograms(selectedPrograms);

        return userData;
    }

    /**
     * Test the getUsername method from the User class.
     */
    public void testGetUsername() {
        // Define an object instance of the (abstract) User class.
        LoggedInUser userData = defineUserObjectInstance();

        // Test whether or not the User object instance's stored data is what we expect it to be.
        assertEquals("TestUser", userData.getUsername());
    }

    /**
     * Test the getEmail method from the User class.
     */
    public void testGetEmail() {
        // Define an object instance of the (abstract) User class.
        LoggedInUser userData = defineUserObjectInstance();

        // Test whether or not the User object instance's stored data is what we expect it to be.
        assertEquals("test_user@test.com", userData.getEmail());
    }

    /**
     * Test the getPassword method from the User class.
     */
    public void testGetPassword() {
        // Define an object instance of the (abstract) User class.
        LoggedInUser userData = defineUserObjectInstance();

        // Test whether or not the User object instance's stored data is what we expect it to be.
        assertEquals("password", userData.getPassword());
    }

    /**
     * Test the getProgram method from the User class.
     */
    public void testGetProgram() {
        // Define an object instance of the (abstract) User class.
        LoggedInUser userData = defineUserObjectInstance();

        // Test whether or not the User object instance's stored data is what we expect it to be.
        assertEquals("Mathematics", userData.getProgram());
    }

    /**
     * Test the getSelectedCourses method from the User class.
     */
    public void testGetSelectedCourses() {
        // Define an object instance of the (abstract) User class.
        LoggedInUser userData = defineUserObjectInstance();

        // Initialize a map variable for a user's selected courses.
        Map selectedCourses = new HashMap<String, String>();
        selectedCourses.put("course1", "course_metadata1");

        // Test whether or not the User object instance's stored data is what we expect it to be.
        assertEquals(selectedCourses, userData.getSelectedCourses());
    }

    /**
     * Test the getSelectedPrograms method from the User class.
     */
    public void testGetSelectedPrograms() {
        // Define an object instance of the (abstract) User class.
        LoggedInUser userData = defineUserObjectInstance();

        // Initialize a map variable for a user's selected programs.
        Map selectedPrograms = new HashMap<String, String>();
        selectedPrograms.put("program1", "program_metadata1");

        // Test whether or not the User object instance's stored data is what we expect it to be.
        assertEquals(selectedPrograms, userData.getSelectedCourses());
    }

    /**
     * Test the getUserSurveyData method from the User class.
     */
    public void testGetUserSurveyData() {
        // Define an object instance of the (abstract) User class.
        LoggedInUser userData = defineUserObjectInstance();

        // Initialize an object instance of the (abstract) Survey class.
        HashMap preferences = new HashMap<String, String>();
        preferences.put("key1", "value1");
        UserData userSurveyData = new UserData("TestUser", "test_user@test.com", "password", "Mathematics", (float) 1, Arrays.asList("CSC207H1"), preferences);

        // Test whether or not the User object instance's stored data is what we expect it to be.
        assertEquals(userSurveyData, userData.getUserSurveyData());
    }

    public void testUpdateUsername() {
        // Define an object instance of the (abstract) User class.
        LoggedInUser userData = defineUserObjectInstance();

        // Update the username within an object instance of the (abstract) User class.
        userData.updateUsername("UpdateTestUser");

        // Test whether or not the User object instance's stored data is what we expect it to be.
        assertEquals("UpdateTestUser", userData.getUsername());
    }

    public void testUpdateUserEmail() {
        // Define an object instance of the (abstract) User class.
        LoggedInUser userData = defineUserObjectInstance();

        userData.updateUserEmail("update_test_user@test.com");

        // Test whether or not the User object instance's stored data is what we expect it to be.
        assertEquals("update_test_user@test.com", userData.getEmail());
    }

    public void testUpdateUserPassword() {
        // Define an object instance of the (abstract) User class.
        LoggedInUser userData = defineUserObjectInstance();

        userData.updateUserPassword("update_password");

        // Test whether or not the User object instance's stored data is what we expect it to be.
        assertEquals("update_password", userData.getPassword());
    }

//    public void testUpdateUserSelectedCourses() {
//        // Define an object instance of the (abstract) User class.
//        LoggedInUser userData = defineUserObjectInstance();
//        userData.updateUserSelectedCourses()
//
//        // Initialize a map variable for a user's selected courses.
//        Map selectedCourses = new HashMap<String, String>();
//        selectedCourses.put("course2", "course_metadata2");
//
//        // Test whether or not the User object instance's stored data is what we expect it to be.
//        assertEquals(selectedCourses, userData.getSelectedCourses());
//    }
//
//    public void testUpdateUserSelectedPrograms() {
//        // Define an object instance of the (abstract) User class.
//        LoggedInUser userData = defineUserObjectInstance();
//    }
//
//    public void testUpdateUserSurveyData() {
//        // Define an object instance of the (abstract) User class.
//        LoggedInUser userData = defineUserObjectInstance();
//    }
}