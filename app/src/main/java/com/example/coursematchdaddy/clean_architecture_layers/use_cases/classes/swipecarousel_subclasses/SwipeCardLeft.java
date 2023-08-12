package com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.swipecarousel_subclasses;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;

import com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.SwipeCarousel;


/**
 * This is a subclass of SwipeCarousel that represents the swipe left action.
 * It extends the SwipeCarousel class.
 */
public class SwipeCardLeft extends SwipeCarousel {

    /**
     * Constructor to initialize the SwipeCardLeft.
     *
     * @param loggedInUser The logged-in user.
     */
    public SwipeCardLeft(User loggedInUser) {
        super(loggedInUser);
    }

    /**
     * This method represents the behavior for the left swipe action.
     * All this method has to do is confirm that the course must be removed.
     *
     * @param course The course data for which the swipe action is performed.
     * @return False just to indicate that course was rejected
     */
    @Override
    public boolean processSwipe(Course course) {
        return false;
    }
}
