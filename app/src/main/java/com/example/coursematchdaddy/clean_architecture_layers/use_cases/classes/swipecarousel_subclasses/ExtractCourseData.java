package com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.swipecarousel_subclasses;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Program;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Survey;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.SwipeCarousel;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.swipecarousel_class_imports_implementations.ExtractCourseDataInterface;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.swipecarousel_class_imports_implementations.ExtractProgramDataInterface;

import java.util.HashMap;
import java.util.List;

public class ExtractCourseData extends SwipeCarousel {
    public ExtractCourseData(User user, Survey surveyData, List<Course> recommendedCourses) {
        super(user, surveyData, recommendedCourses);
    }

    /**
     * return the course title from the database, given courseData
     * @param courseData: Course
     * @return String
     */
    public String getCourseTitle(Course courseData) {
        return courseData.getCourseTitle();
    }

    /**
     * return the course code from the database, given courseData
     * @param courseData: Course
     * @return String
     */
    public String getCourseCode(Course courseData) {
        return courseData.getCourseCode();
    }

    /**
     * return the course description from the database, given courseData
     * @param courseData: Course
     * @return String
     */
    public String getCourseDescription(Course courseData) {
        return courseData.getCourseDescription();
    }

    /**
     * return the course image url from the database, given courseData
     * @param courseData: Course
     * @return String
     */
    public String getImageURL(Course courseData) {
        return courseData.getCourseImageURL();
    }

    /**
     * return the course miscellaneous data from the database, given courseData
     * @param courseData: Course
     * @return HashMap<String, Object>
     */
    public HashMap<String, Object> getMiscellaneousCourseData(Course courseData) {
        return courseData.getMiscellaneousCourseData();
    }
    
    public void extractCourseData(ExtractCourseDataInterface extractor) {

    }
    
    public void extractProgramData(ExtractProgramDataInterface extractor) {

    }

    @Override
    public boolean addCoursePreference(Course courseData) {
        return false;
    }

    @Override
    public boolean removeCourseFromCarousel(SwipeCarousel carouselData, Course courseData) {
        return false;
    }
    
    public String collectCarouselSwipe() {
        return null;
    }
    
    public String getTitle(Program programData) {
        return null;
    }
    
    public String getCode(Program programData) {
        return null;
    }
    
    public String getDescription(Program programData) {
        return null;
    }
}
