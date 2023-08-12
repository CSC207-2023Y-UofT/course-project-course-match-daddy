package com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.recommendationalgorithm_subclasses;

import junit.framework.TestCase;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Program;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.course_subclasses.ArtsAndSciencesCourse;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.user_subclasses.LoggedInUser;

import java.util.ArrayList;
import java.util.List;

public class ExtractProgramsRecommendationsTest extends TestCase {

    public void testGetProgramRecommendations() {
        // Creating a mock user
        User user = new LoggedInUser("TestUser", "TestEmail","TestPassword");

        // Creating mock courses
        Course course1 = new ArtsAndSciencesCourse("CSC108", "Introduction to Programming", "Introductory programming course", "testurl", null);
        Course course2 = new ArtsAndSciencesCourse("MAT201", "Linear Algebra", "Introduction to linear algebra", "testurl", null);
        Course course3 = new ArtsAndSciencesCourse("PHY301", "Quantum Mechanics", "Advanced physics course", "testurl", null);

        // Creating mock programs
        Program program1 = new Program("Computer Science", "CS101", "Computer Science program", "CSC108 MAT201");
        Program program2 = new Program("Mathematics", "MATH101", "Mathematics program", "MAT201 PHY301");
        Program program3 = new Program("Physics", "PHY101", "Physics program", "PHY301");

        List<Course> courseList = new ArrayList<>();
        courseList.add(course1);
        courseList.add(course2);
        courseList.add(course3);

        List<Program> programList = new ArrayList<>();
        programList.add(program1);
        programList.add(program2);
        programList.add(program3);

        // Creating the ExtractProgramsRecommendations instance
        ExtractProgramsRecommendations extractor = new ExtractProgramsRecommendations(user, courseList, programList);

        // Testing the getProgramRecommendations method
        List<Program> recommendations = extractor.getProgramRecommendations();

        //Produces correct recommendations given this course data
        assertEquals(recommendations.get(0), program1);
        assertEquals(recommendations.get(1), program2);
        assertEquals(recommendations.get(2), program3);
    }
}
