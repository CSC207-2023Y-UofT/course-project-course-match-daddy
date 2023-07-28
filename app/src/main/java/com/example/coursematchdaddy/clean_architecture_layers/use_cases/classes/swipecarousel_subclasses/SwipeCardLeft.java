package com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.swipecarousel_subclasses;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Program;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Survey;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.SwipeCarousel;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.swipecarousel_class_imports_implementations.ExtractCourseDataInterface;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.swipecarousel_class_imports_implementations.ExtractProgramDataInterface;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.swipecarousel_class_imports_implementations.SwipeCardLeftInterface;

import java.util.HashMap;
import java.util.List;

// The logic behind this method is handled in the SwipeCarousel Class
public class SwipeCardLeft extends SwipeCarousel implements SwipeCardLeftInterface {
    public SwipeCardLeft(User user, Survey surveyData, List<Course> recommendedCourses) {
        super(user, surveyData, recommendedCourses);
    }

    @Override
    public boolean removeCourseFromCarousel(SwipeCarousel carouselData, Course courseData) {
        return super.removeCourseFromCarousel(carouselData, courseData);
    }
}
