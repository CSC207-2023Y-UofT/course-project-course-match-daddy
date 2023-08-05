package com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.swipecarousel_class_imports_implementations;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;

/**
 * Define the contract for recording the carousel swipe of a user.
 */
public interface CollectCarouselSwipeInterface {
    /**
     * Collect the users carousel swipe action.
     */
    boolean processSwipe(Course courseData);
}
