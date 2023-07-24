package com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.swipecarousel_subclasses;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.SwipeCarousel;

import java.util.HashMap;

public class ExtractCourseData extends SwipeCarousel {
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
}
