package com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.swipecarousel_subclasses;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.course_subclasses.ArtsAndSciencesCourse;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.user_subclasses.LoggedInUser;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class SwipeCardRightTest {

    @Test
    public void testProcessSwipe() {
        User user = new LoggedInUser("abc", "email", "password");
        SwipeCardRight swipeCardRight = new SwipeCardRight(user);

        HashMap<String, Object> mockMisc = new HashMap<>();
        Course mockCourse = new ArtsAndSciencesCourse("Title", "Code", "Desc", "URL", mockMisc);

        boolean result = swipeCardRight.processSwipe(mockCourse);

        Assert.assertTrue(result); // The method should return true for a successful addition
        Assert.assertTrue(user.getSelectedCourses().containsKey(mockCourse.getCourseTitle())); // Check if the course is added
    }

    /*
    @Test
    public void testProcessSwipe_addMultipleCoursesToSelected() {
        User user = new LoggedInUser("abc", "email", "password");
        SwipeCardRight swipeCardRight = new SwipeCardRight(user);

        HashMap<String, Object> mockMisc = new HashMap<>();
        Course courseA = new ArtsAndSciencesCourse("Title", "Code", "Desc", "URL", mockMisc);
        Course courseB = new ArtsAndSciencesCourse("TitleB", "codeB", "DescB", "URLB", mockMisc);

        boolean resultA = swipeCardRight.processSwipe(courseA);
        boolean resultB = swipeCardRight.processSwipe(courseB);

        Assert.assertTrue(resultA); // The method should return true for a successful addition of CourseA
        Assert.assertTrue(resultB); // The method should return true for a successful addition of CourseB
        Assert.assertTrue(user.getSelectedCourses().containsKey(courseA.getCourseTitle()));
    }
    */
}