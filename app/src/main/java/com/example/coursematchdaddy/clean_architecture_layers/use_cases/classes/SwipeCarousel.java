package com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Survey;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.user_subclasses.LoggedInUser;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.swipecarousel_class_imports_implementations.CollectCarouselSwipeInterface;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.swipecarousel_class_imports_implementations.SwipeCardLeftInterface;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.swipecarousel_class_imports_implementations.SwipeCardRightInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is an abstract class that implements the CollectCarouselSwipeInterface.
 * It provides a common structure for SwipeCardLeft and SwipeCardRight classes.
 */
public abstract class SwipeCarousel implements CollectCarouselSwipeInterface {

    protected User loggedInUser;

    /**
     * Constructor to initialize the SwipeCarousel.
     *
     * @param loggedInUser The logged-in user.
     */
    public SwipeCarousel (User loggedInUser){
        this.loggedInUser = loggedInUser;
    }

    /**
     * This method is implemented by the subclasses SwipeCardLeft and SwipeCardRight.
     * It processes the user's swipe action on a course and returns a boolean value
     * indicating if the action succeeded.
     *
     * @param courseData The course data for which the swipe action is performed.
     * @return True if the swipe was processed.
     */
    @Override
    public abstract boolean processSwipe(Course courseData);
}
