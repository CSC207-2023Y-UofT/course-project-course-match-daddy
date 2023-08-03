package com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.recommendationalgorithm_subclasses;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.RecommendationAlgorithm;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.recommendationalgorithm_class_imports_implementations.ExtractCoursesRecommendationsInterface;

import java.util.List;

public class ExtractCoursesRecommendations extends RecommendationAlgorithm implements ExtractCoursesRecommendationsInterface {
    /**
     * Creates a RecommendationAlgorithm object.
     *
     * @param user       The user for whom courses need to be recommended.
     * @param courseList The list of all available courses to choose from.
     */
    public ExtractCoursesRecommendations(User user, List<Course> courseList) {
        super(user, courseList);
    }

    @Override
    public List<Course> getCourses() {
        return super.getCourses();
    }
}
