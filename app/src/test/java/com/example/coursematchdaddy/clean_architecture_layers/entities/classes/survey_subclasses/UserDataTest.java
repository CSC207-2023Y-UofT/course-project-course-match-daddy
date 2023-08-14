package com.example.coursematchdaddy.clean_architecture_layers.entities.classes.survey_subclasses;

import static org.junit.Assert.assertEquals;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class UserDataTest{

    private static UserData survey;
    @Before
    public void testCreator() {
        //Setting up UserData object
        ArrayList<String> coursesTaken = new ArrayList<>();
        coursesTaken.add("ISP100");
        HashMap<String, String> preferences = new HashMap<>();
        preferences.put("interest", "objectivity");
        survey = new UserData("exampleUser", "example@mail.com", "example", "Computer Science", (float) 3.0, coursesTaken, preferences);
    }

    @Test
    public void testGetUserSurveyData() {
        HashMap<String, Object> expected = new HashMap<>();
        expected.put("program", survey.getProgram());
        expected.put("numOfCredits", survey.getNumCredits());
        expected.put("coursesTaken", survey.getCoursesTaken());
        expected.put("preferences", survey.getCompleteData());

        //Tests for the right surveydata
        assertEquals(expected, survey.getUserSurveyData());
    }

    @Test
    public void testGetUsername() {
        //Testing that the getter method works
        String expected = "exampleUser";
        assertEquals(expected, survey.getUsername());
    }

    @Test
    public void testGetEmail() {
        //Testing that the getter method works
        String expected = "example@mail.com";
        assertEquals(expected, survey.getEmail());
    }

    @Test
    public void testGetPassword() {
        //Testing that the getter method works
        String expected = "example";

        assertEquals(expected, survey.getPassword());
    }

    @Test
    public void testSetPassword() {
        //Testing that the setter method works
        String newPassword  = "new";
        survey.setPassword(newPassword);

        //Making sure that it was assigned to the object
        assertEquals(newPassword, survey.getPassword());
    }

    @Test
    public void testSetUsername() {
        //Testing that the setter method works
        String newUsername = "exampleUser2";
        survey.setUsername(newUsername);

        //Making sure that it was assigned to the object
        assertEquals(newUsername, survey.getUsername());
    }

    @Test
    public void testSetEmail() {
        //Testing that the setter method works
        String newEmail = "example2@mail.com";
        survey.setEmail(newEmail);

        //Making sure that it was assigned to the object
        assertEquals(newEmail, survey.getEmail());
    }
}