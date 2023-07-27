package com.example.coursematchdaddy.clean_architecture_layers.gateways.classes;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.swipecarousel_class_imports_implementations.ExtractCourseDataInterface;

import java.util.HashMap;

public class DBCoursesGateway implements ExtractCourseDataInterface {
    @Override
    public String getCourseTitle(Course courseData) {
        return null;
    }

    @Override
    public String getCourseCode(Course courseData) {
        return null;
    }

    @Override
    public String getCourseDescription(Course courseData) {
        return null;
    }

    @Override
    public String getImageURL(Course courseData) {
        return null;
    }

    @Override
    public HashMap<String, Object> getMiscellaneousCourseData(Course courseData) {
        return null;
    }
}
