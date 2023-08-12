package com.example.coursematchdaddy.clean_architecture_layers.presenters.classes;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.recommendationalgorithm_class_imports_implementations.ViewCourseDataInterface;

import java.util.HashMap;

public class CoursePresenter implements ViewCourseDataInterface {
    private final HashMap<String, Course> courseList;


    /**
     * @param courseList Course list1
     */
    public CoursePresenter(HashMap<String,Course> courseList) {
        this.courseList = courseList;
    }


    /**
     * return course map containing course titles, codes, and descriptions
     *
     * @return Map < String, String>
     */
    @Override
    public HashMap<String, Course> getCourseData() {
        return courseList;
    }
}