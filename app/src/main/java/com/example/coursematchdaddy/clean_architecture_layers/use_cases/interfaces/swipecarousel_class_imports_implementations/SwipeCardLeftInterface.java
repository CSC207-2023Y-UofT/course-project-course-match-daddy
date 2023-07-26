package com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.swipecarousel_class_imports_implementations;

/**
 * Defines the contract for handling left swipes on course cards within a carousel.
 * The course is removed from the list of recommended courses.
 */
public interface SwipeCardLeftInterface {
    /**
     * Removes a course from the list of recommended courses.
     *
     * @param carouselData - The SwipeCarousel instance representing the carousel.
     * @param courseData - The course to be removed from the list of recommended courses.
     * @return - True if the course was removed successfully, false otherwise.
     */
    boolean removeCourseFromCarousel(SwipeCarousel carouselData, Course courseData);
}
