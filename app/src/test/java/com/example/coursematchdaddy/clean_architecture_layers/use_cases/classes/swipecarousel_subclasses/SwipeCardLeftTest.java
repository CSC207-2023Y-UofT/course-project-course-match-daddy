package com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.swipecarousel_subclasses;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.course_subclasses.ArtsAndSciencesCourse;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.user_subclasses.LoggedInUser;

import junit.framework.TestCase;

import java.util.HashMap;

public class SwipeCardLeftTest extends TestCase {

    public void testProcessSwipe() {
        User user = new LoggedInUser("abc", "email", "password");
        SwipeCardLeft swipeCardLeft = new SwipeCardLeft(user);

        HashMap<String, Object> mockMisc = new HashMap<>();
        Course mockCourse = new ArtsAndSciencesCourse("Title", "Code", "Desc", "URL", mockMisc);

        boolean result = swipeCardLeft.processSwipe(mockCourse);
        assertFalse(result);
    }
    public void testProcessSwipe_rejectCourse_multipleCourses() {
        User user = new LoggedInUser("abc", "email", "password");
        SwipeCardLeft swipeCardLeft = new SwipeCardLeft(user);

        HashMap<String, Object> mockMisc = new HashMap<>();
        Course courseA = new ArtsAndSciencesCourse("Title1", "Code1", "Desc1", "URL", mockMisc);
        Course courseB = new ArtsAndSciencesCourse("Title", "Code", "Desc", "URL", mockMisc);

        boolean resultA = swipeCardLeft.processSwipe(courseA);
        boolean resultB = swipeCardLeft.processSwipe(courseB);

        assertFalse(resultA); // CourseA should be rejected
        assertFalse(resultB); // CourseB should also be rejected
    }

}