package com.example.coursematchdaddy;

import static org.junit.Assert.assertEquals;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Program;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Survey;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.course_subclasses.ArtsAndSciencesCourse;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.program_subclasses.Type1Program;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.survey_subclasses.UserData;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.user_subclasses.LoggedInUser;
import com.example.coursematchdaddy.clean_architecture_layers.gateways.classes.UserDB;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.updatesettings_subclasses.SaveSurveyData;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(AndroidJUnit4.class)
public class UpdateSettingsTest{

    private static final String USERNAME = "testUser";
    private static final String PASSWORD = "testPassword";
    private static final String EMAIL = "test@example.com";


    @Test
    public void testUpdateSettings() {
        //all variables needed to construct the objects
        float numCredits = (float) 3.0;
        List<String> coursesTaken = new ArrayList<>();
        HashMap<String, String> completeData = new HashMap<>();
        coursesTaken.add("ISP100");
        User userData = new LoggedInUser(USERNAME, EMAIL, PASSWORD);

        SaveSurveyData settingsUpdate = new SaveSurveyData(userData);

        UserDB db = new UserDB();
        db.verifyUser(userData);
        db.updateUserData(userData);

        String newUsername = "newUser";
        String newEmail = "newemail@gmail.com";
        String newPassword = "newPassword";
        String newProgram = "Mathematics";

        Map<String, Course> selectedCourses = new HashMap<>();
        Course tempCourse = new ArtsAndSciencesCourse("Writing", "ISP100", "Good", "/", new HashMap<>() );
        selectedCourses.put(tempCourse.getCourseTitle(), tempCourse);

        Map<String, Program> selectedPrograms = new HashMap<>();
        Program tempProgram = new Type1Program("English", "ENG", "good", "Nothing");
        selectedPrograms.put(tempProgram.getProgramTitle(), tempProgram);

        Survey surveyInfo = new UserData(newUsername, newEmail, newPassword, newProgram, numCredits, coursesTaken, completeData);

        settingsUpdate.updateSettings(newUsername, newEmail, newPassword, selectedCourses, selectedPrograms, surveyInfo, db);

        assertEquals(userData.getEmail(), newEmail);
        assertEquals(userData.getUserSurveyData(), surveyInfo);
        assertEquals(userData.getUsername(), newUsername);
        assertEquals(userData.getPassword(), newPassword);
        assertEquals(userData.getSelectedCourses(), selectedCourses);
        assertEquals(userData.getSelectedPrograms(), selectedPrograms);
    }
}