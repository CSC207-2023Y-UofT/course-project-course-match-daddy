package com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Survey;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.survey_subclasses.UserData;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubmitSurveyTest extends TestCase {

    private static final String USERNAME = "testUser";
    private static final String PASSWORD = "testPassword";
    private static final String EMAIL = "test@example.com";

    private static final String PROGRAM = "Computer Science";




    public void testUserSubmit() {
        float numCredits = (float) 3.0;

        List<String> coursesTaken = new ArrayList<>();
        HashMap<String, String> completeData = new HashMap<>();
        coursesTaken.add("ISP100");


        Survey expected = new UserData(USERNAME, EMAIL, PASSWORD, PROGRAM, numCredits, coursesTaken, completeData);

        SubmitSurvey surveyUseCase = new SubmitSurvey();
        Survey result = surveyUseCase.userSubmit(USERNAME, PASSWORD, EMAIL, PROGRAM, numCredits, coursesTaken, completeData);

        assertEquals(expected.getProgram(), result.getProgram());
        assertEquals(expected.getNumCredits(), result.getNumCredits());
        assertEquals(expected.getCompleteData(), result.getCompleteData());
        assertEquals(expected.getCoursesTaken(), result.getCoursesTaken());
    }
}