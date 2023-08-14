
package com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.recommendationalgorithm_class_imports_implementations;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;

import java.util.List;

public interface ExtractCoursesRecommendationsInterface {

    /**
     * Retrieves a list of recommended courses for a given user
     * @return A List of recommended Course objects.
     */
    List<Course> getCourseRecommendations();
}
