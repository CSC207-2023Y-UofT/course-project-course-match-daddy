package com.example.coursematchdaddy;

import com.example.coursematchdaddy.clean_architecture_layers.controllers.classes.CarouselController;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.course_subclasses.ArtsAndSciencesCourse;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.user_subclasses.LoggedInUser;
import com.example.coursematchdaddy.clean_architecture_layers.gateways.classes.UserDB;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class CarouselControllerTest {
    private final String username = "username";
    private final String email = "email";
    private final String password = "password";

    @Test
    public void testOnSwipeLeft() {
        //Create the user and add it to the "database"
        User mockUser = new LoggedInUser(username, email, password);
        UserDB userDB = new UserDB();
        userDB.updateUserData(mockUser);

        //Create a Mock course
        HashMap<String, Object> mockMisc = new HashMap<>();
        Course mockCourse = new ArtsAndSciencesCourse("Title", "Code", "Desc", "URL", mockMisc);


        //Initialize the controller
        CarouselController carouselController = new CarouselController(username);

        //Call the onSwipeLeft method
        carouselController.onSwipeLeft(mockCourse);

        Assert.assertEquals(0, mockUser.getSelectedCourses().size());
    }

    @Test
    public void testOnSwipeRight() {
        User mockUser = new LoggedInUser(username, email, password);
        UserDB userDB = new UserDB();
        userDB.updateUserData(mockUser);

        //Create a Mock course
        HashMap<String, Object> mockMisc = new HashMap<>();
        Course mockCourse = new ArtsAndSciencesCourse("Title", "Code", "Desc", "URL", mockMisc);


        //Initialize the controller
        CarouselController carouselController = new CarouselController(username);

        //Call the onSwipeLeft method
        carouselController.onSwipeRight(mockCourse);

        Assert.assertNotNull(mockUser.getSelectedCourses());
    }
}
