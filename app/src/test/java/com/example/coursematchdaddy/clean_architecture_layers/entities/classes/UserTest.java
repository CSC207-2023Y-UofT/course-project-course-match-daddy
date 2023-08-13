package com.example.coursematchdaddy.clean_architecture_layers.entities.classes;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.course_subclasses.ArtsAndSciencesCourse;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.program_subclasses.Type1Program;
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
        HashMap<String, String> preferences = new HashMap<String, String>();
        preferences.put("key1", "value1");
        UserData userSurveyData = new UserData("TestUser", "test_user@test.com", "password", "Mathematics", (float) 1, Arrays.asList("CSC207H1"), preferences);

        // Define an object instance of the (abstract) User Class.
        LoggedInUser userData = new LoggedInUser(userSurveyData.getUsername(), userSurveyData.getEmail(), userSurveyData.getPassword());

        // Update the object instance of the (abstract) User class.
        userData.updateProgram(userSurveyData.getProgram());
        userData.updateNumCredits(userSurveyData.getNumCredits());
        userData.updateUserSurveyData(userSurveyData);

        // Update the object instance of the (abstract) User class with selected courses (from the carousel view).
        Map<String, Course> selectedCourses = new HashMap<String, Course>();
        HashMap<String, Object> miscellaneousCourse1Data = new HashMap<String, Object>();
        miscellaneousCourse1Data.put("miscellaneousCourse1Data1Key", "miscellaneousCourse1Data1Value");
        Course course1Metadata = new ArtsAndSciencesCourse("course1Title", "course1Code", "course1Description", "course1ImageURL", miscellaneousCourse1Data);
        selectedCourses.put("course1", course1Metadata);
        userData.updateUserSelectedCourses(selectedCourses);

        // Update the object instance of the (abstract) User class with selected program(s).
        Map<String, Program> selectedPrograms = new HashMap<String, Program>();
        Program program1Metadata = new Type1Program("program1Title", "program1Code", "program1Description", "program1CompletionRequirements");
        selectedPrograms.put("program1", program1Metadata);
        userData.updateUserSelectedPrograms(selectedPrograms);

        // Return the example userData for testing.
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
        Map<String, Course> selectedCourses = new HashMap<String, Course>();
        HashMap<String, Object> miscellaneousCourse1Data = new HashMap<String, Object>();
        miscellaneousCourse1Data.put("miscellaneousCourse1Data1Key", "miscellaneousCourse1Data1Value");
        Course course1Metadata = new ArtsAndSciencesCourse("course1Title", "course1Code", "course1Description", "course1ImageURL", miscellaneousCourse1Data);
        selectedCourses.put("course1", course1Metadata);

        // Test whether or not the User object instance's stored data is what we expect it to be.
        assertEquals(selectedCourses.get("course1"), userData.getSelectedCourses().get("course1"));
    }

    /**
     * Test the getSelectedPrograms method from the User class.
     */
    public void testGetSelectedPrograms() {
        // Define an object instance of the (abstract) User class.
        LoggedInUser userData = defineUserObjectInstance();

        // Initialize a map variable for a user's selected programs.
        Map<String, Program> selectedPrograms = new HashMap<String, Program>();
        Program program1Metadata = new Type1Program("program1Title", "program1Code", "program1Description", "program1CompletionRequirements");
        selectedPrograms.put("program1", program1Metadata);

        // Test whether or not the User object instance's stored data is what we expect it to be.
        assertEquals(selectedPrograms.get("program1"), userData.getSelectedPrograms().get("program1"));
    }

    /**
     * Test the getUserSurveyData method from the User class.
     */
    public void testGetUserSurveyData() {
        // Define an object instance of the (abstract) User class.
        LoggedInUser userData = defineUserObjectInstance();

        // Define an object instance of the (abstract) Survey class.
        HashMap<String, String> preferences = new HashMap<String, String>();
        preferences.put("key1", "value1");
        UserData userSurveyData = new UserData("TestUser", "test_user@test.com", "password", "Mathematics", (float) 1, Arrays.asList("CSC207H1"), preferences);

        // Test whether or not the User object instance's stored data is what we expect it to be.
        assertEquals(userSurveyData.getCoursesTaken(), userData.getUserSurveyData().getCoursesTaken());
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

    public void testUpdateUserSelectedCourses() {
        // Define an object instance of the (abstract) User class.
        LoggedInUser userData = defineUserObjectInstance();

        // Initialize a map variable for a user's selected courses.
        Map<String, Course> selectedCourses = new HashMap<String, Course>();
        HashMap<String, Object> miscellaneousCourse1Data = new HashMap<String, Object>();
        miscellaneousCourse1Data.put("miscellaneousCourse1Data1Key", "miscellaneousCourse1Data1Value");
        Course course1Metadata = new ArtsAndSciencesCourse("course1Title", "course1Code", "course1Description", "course1ImageURL", miscellaneousCourse1Data);
        selectedCourses.put("course1", course1Metadata);

        // Add a second course.
        HashMap<String, Object> miscellaneousCourse2Data = new HashMap<String, Object>();
        miscellaneousCourse2Data.put("miscellaneousCourse2Data1Key", "miscellaneousCourse2Data1Value");
        Course course2Metadata = new ArtsAndSciencesCourse("course2Title", "course2Code", "course2Description", "course2ImageURL", miscellaneousCourse2Data);
        selectedCourses.put("course2", course2Metadata);

        // Update the userData to contain the second course.
        userData.updateUserSelectedCourses(selectedCourses);

        // Test whether or not the User object instance's stored data is what we expect it to be.
        assertEquals(selectedCourses, userData.getSelectedCourses());
    }

    public void testUpdateUserSelectedPrograms() {
        // Define an object instance of the (abstract) User class.
        LoggedInUser userData = defineUserObjectInstance();

        // Initialize a map variable for a user's selected programs.
        Map<String, Program> selectedPrograms = new HashMap<String, Program>();
        Program program1Metadata = new Type1Program("program1Title", "program1Code", "program1Description", "program1CompletionRequirements");
        selectedPrograms.put("program1", program1Metadata);

        // Add a second program.
        Program program2Metadata = new Type1Program("program2Title", "program2Code", "program2Description", "program2CompletionRequirements");
        selectedPrograms.put("program2", program2Metadata);

        // Update the userData to contain the second program.
        userData.updateUserSelectedPrograms(selectedPrograms);

        // Test whether or not the User object instance's stored data is what we expect it to be.
        assertEquals(selectedPrograms, userData.getSelectedPrograms());
    }

    public void testUpdateUserSurveyData() {
        // Define an object instance of the (abstract) User class.
        LoggedInUser userData = defineUserObjectInstance();

        // Define an object instance of the (abstract) Survey class.
        HashMap<String, String> preferences = new HashMap<String, String>();
        preferences.put("key1", "value1");
        UserData userSurveyData = new UserData("TestUser", "test_user@test.com", "password", "Mathematics", (float) 1, Arrays.asList("CSC207H1"), preferences);
        userSurveyData.setUsername("UpdateTestUser");

        userData.updateUserSurveyData(userSurveyData);

        // Test whether or not the User object instance's stored data is what we expect it to be.
        assertEquals(userSurveyData, userData.getUserSurveyData());
    }
}