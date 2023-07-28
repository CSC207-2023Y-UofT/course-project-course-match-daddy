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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SwipeCarousel implements SwipeCardLeftInterface, SwipeCardRightInterface{

    private List<Course> courseList;
    private User user;

    public SwipeCarousel (User user, Survey surveyData) {
        this.courseList = new ArrayList<>();
        this.user = user;
        RecommendationAlgorithm recommendationAlgorithm = new RecommendationAlgorithm();
        this.courseList = recommendationAlgorithm.getCourses(surveyData, user);
    }

    public List<Course> getCourseList(){
        return courseList;
    }

    public boolean addCoursePreference(Course courseData){
        Map<String, Course> Map = new HashMap<>();
        Map.put(courseData.getCourseTitle(), courseData);
        this.user.updateUserSelectedCourses(Map);

        return true;
    }
    public boolean removeCourseFromCarousel(SwipeCarousel carouselData, Course courseData){
        return(this.courseList.remove(courseData));
    }
}
