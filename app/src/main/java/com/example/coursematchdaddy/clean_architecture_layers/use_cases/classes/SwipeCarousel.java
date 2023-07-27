package com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Survey;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.swipecarousel_class_imports_implementations.CollectCarouselSwipeInterface;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.swipecarousel_class_imports_implementations.ExtractCourseDataInterface;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.swipecarousel_class_imports_implementations.ExtractProgramDataInterface;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.swipecarousel_class_imports_implementations.SwipeCardLeftInterface;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.swipecarousel_class_imports_implementations.SwipeCardRightInterface;

import java.util.ArrayList;
import java.util.List;

public abstract class SwipeCarousel implements ExtractCourseDataInterface, ExtractProgramDataInterface, SwipeCardRightInterface,
        SwipeCardLeftInterface, CollectCarouselSwipeInterface {

    private List<Course> courseList;
    private User user;

    public SwipeCarousel (User user, Survey surveydata) {
        this.courseList = new ArrayList<>();
        RecommendationAlgorithm recommendationAlgorithm = new RecommendationAlgorithm();
        this.courseList = recommendationAlgorithm.getCourses(surveydata, user);
    }



    public abstract void extractCourseData(ExtractCourseDataInterface extractor);
    public abstract void extractProgramData(ExtractProgramDataInterface extractor);
    public abstract boolean addCoursePreference(Course courseData);
    public abstract boolean removeCourseFromCarousel(SwipeCarousel carouselData, Course courseData);
}
