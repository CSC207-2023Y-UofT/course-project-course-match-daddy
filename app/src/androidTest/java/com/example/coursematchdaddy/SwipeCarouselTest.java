package com.example.coursematchdaddy;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.course_subclasses.ArtsAndSciencesCourse;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.user_subclasses.LoggedInUser;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.SwipeCarousel;


import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class SwipeCarouselTest {

    @Test
    public void testProcessSwipe() {
        User testUser = new LoggedInUser("Username", "email", "password");
        HashMap<String, Object> mockMisc = new HashMap<>();
        Course mockCourse = new ArtsAndSciencesCourse("Title", "Code", "Desc", "URL", mockMisc);
        SwipeCarousel mockSwipeCarousel = new SwipeCarousel(testUser) {
            @Override
            public boolean processSwipe(Course courseData) {
                return false;
            }
        };

        Assert.assertFalse(mockSwipeCarousel.processSwipe(mockCourse));
    }
}