package com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.recommendationalgorithm_class_imports_implementations;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;

public interface ViewCourseDataInterface {
    /**
     * return the course associated with courseCode
     * @param courseCode
     * @return Course
     */
    public Course getCourseData(String courseCode);
}
