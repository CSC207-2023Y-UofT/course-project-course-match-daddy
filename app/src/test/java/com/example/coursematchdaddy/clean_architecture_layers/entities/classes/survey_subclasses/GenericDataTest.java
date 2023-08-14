package com.example.coursematchdaddy.clean_architecture_layers.entities.classes.survey_subclasses;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class GenericDataTest {

    private static GenericData survey;
    @Before
    public void testCreator() {
        //Setting up GenericData object
        ArrayList<String> coursesTaken = new ArrayList<>();
        coursesTaken.add("ISP100");
        HashMap<String, String> preferences = new HashMap<>();
        preferences.put("interest", "objectivity");
        survey = new GenericData("Computer Science", (float) 3.0, coursesTaken, preferences);
    }

    @Test
    public void testGetGenericSurveyData() {
        //Testing that the getter method works
        HashMap<String, Object> expected = new HashMap<>();
        expected.put("program", survey.getProgram());
        expected.put("numOfCredits", survey.getNumCredits());
        expected.put("courses", survey.getCoursesTaken());
        expected.put("preferences", survey.getCompleteData());

        assertEquals(expected, survey.getGenericSurveyData());
    }
}