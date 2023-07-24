
package com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.recommendationalgorithm_class_imports_implementations;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;

import java.util.List;

public interface ViewCoursesRecommendationsInterface {

    /**
     * Retrieves a list of recommended courses for a given user based on the provided user data.
     *
     * @param userData The User object containing the relevant data for generating course recommendations.
     * @return A List of recommended Course objects.
     */
    List<Course> getCourseRecommendations(User userData);
}
