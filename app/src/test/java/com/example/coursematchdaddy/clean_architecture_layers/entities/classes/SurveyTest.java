package com.example.coursematchdaddy.clean_architecture_layers.entities.classes;

import static org.junit.Assert.assertEquals;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.survey_subclasses.GenericData;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SurveyTest {

    private static Survey survey;
    @Before
    public void testCreator() {
        //Setting up Survey through subclass GenericData object
        ArrayList<String> coursesTaken = new ArrayList<>();
        coursesTaken.add("ISP100");
        HashMap<String, String> preferences = new HashMap<>();
        preferences.put("interest", "objectivity");
        survey = new GenericData("Computer Science", (float) 3.0, coursesTaken, preferences);
    }

    @Test
    public void testGetProgram() {
        //Testing that the getter method works
        String expected = "Computer Science";
        assertEquals(survey.getProgram(), expected);

    }

    @Test
    public void testGetNumCredits() {
        //Testing that the getter method works
        Float expected = (float) 3.0;
        assertEquals(survey.getNumCredits(), expected);
    }

    @Test
    public void testGetCoursesTaken() {
        //Testing that the getter method works
        List<String> expected = new ArrayList<>();
        expected.add("ISP100");
        assertEquals(expected, survey.getCoursesTaken());
    }

    @Test
    public void testGetCompleteData() {
        //Testing that the getter method works
        HashMap<String, String> expected = new HashMap<>();
        expected.put("interest", "objectivity");
        assertEquals(expected, survey.getCompleteData());
    }
}