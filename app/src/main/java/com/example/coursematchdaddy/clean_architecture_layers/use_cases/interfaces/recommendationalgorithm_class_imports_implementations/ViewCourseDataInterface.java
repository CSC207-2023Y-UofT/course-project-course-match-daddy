package com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.recommendationalgorithm_class_imports_implementations;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import java.util.Map;

public interface ViewCourseDataInterface {
    /**
     * return the course associated with courseCode
     * @param courseCode: String
     * @return Course
     */
    public Map<String, String> getCourseData(String courseCode);

    /**
     * return the data associated with a selected course
     * @param course Course object that is selected
     * @return Map<String, String> the data that needs to be displayed
     */
    public Map<String, String> getCourseData(Course course);
}
