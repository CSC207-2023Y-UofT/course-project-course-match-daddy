package com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.swipecarousel_class_imports_implementations;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.SwipeCarousel;

/**
 * Define the contract for handling right swipes on course cards within a carousel.
 * The selected course is added to the user’s list of selected courses, and it's removed from the carousel.
 */
public interface SwipeCardRightInterface {
    /**
     * Adds a course to the user's course preferences list.
     *
     * @param courseData - The course to be added to the user's preferences.
     * @return - True if the course was added successfully, false otherwise.
     */
    boolean addCoursePreference(Course courseData);

    /**
     * Removes a course from the carousel.
     *
     * @param carouselData - The SwipeCarousel instance representing the carousel.
     * @param courseData - The course to be removed from the carousel.
     * @return - True if the course was removed successfully, false otherwise.
     */
    boolean removeCourseFromCarousel(SwipeCarousel carouselData, Course courseData);
}


