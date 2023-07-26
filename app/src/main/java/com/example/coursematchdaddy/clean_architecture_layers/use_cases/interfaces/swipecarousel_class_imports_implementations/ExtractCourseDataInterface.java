package com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.swipecarousel_class_imports_implementations;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;

import java.util.HashMap;

public interface ExtractCourseDataInterface {
    /**
     * return the course title from the database, given courseData
     * @param courseData: Course
     * @return String
     */
    public String getCourseTitle(Course courseData);

    /**
     * return the course code from the database, given courseData
     * @param courseData: Course
     * @return String
     */
    public String getCourseCode(Course courseData);

    /**
     * return the course description from the database, given courseData
     * @param courseData: Course
     * @return String
     */
    public String getCourseDescription(Course courseData);

    /**
     * return the course image url from the database, given courseData
     * @param courseData: Course
     * @return String
     */
    public String getImageURL(Course courseData);

    /**
     * return the course miscellaneous data from the database, given courseData
     * @param courseData: Course
     * @return HashMap<String, Object>
     */
    public HashMap<String, Object> getMiscellaneousCourseData(Course courseData);
}
