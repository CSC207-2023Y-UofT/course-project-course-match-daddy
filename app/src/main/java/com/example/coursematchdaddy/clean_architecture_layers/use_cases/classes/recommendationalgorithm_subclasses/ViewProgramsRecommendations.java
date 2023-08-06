package com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.recommendationalgorithm_subclasses;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.RecommendationAlgorithm;

import java.util.List;

public class ViewProgramsRecommendations extends RecommendationAlgorithm {
    /**
     * Creates a RecommendationAlgorithm object.
     *
     * @param user       The user for whom courses need to be recommended.
     * @param courseList The list of all available courses to choose from.
     */
    public ViewProgramsRecommendations(User user, List<Course> courseList) {
        super(user, courseList);
    }
}
