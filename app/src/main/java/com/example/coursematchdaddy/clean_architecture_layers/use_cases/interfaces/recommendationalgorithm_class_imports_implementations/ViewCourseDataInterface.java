package com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.recommendationalgorithm_class_imports_implementations;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;

import java.util.HashMap;
import java.util.List;
public interface ViewCourseDataInterface {
    /**
     * return a course map containing course titles, codes, and descriptions
     *
     * @return Map<String, String>
     */
    public HashMap<String, Course> getCourseData();

}
