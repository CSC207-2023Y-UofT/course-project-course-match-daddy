package com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.recommendationalgorithm_subclasses;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.RecommendationAlgorithm;

import java.util.List;

public class ViewCourseData extends RecommendationAlgorithm {
    private User user;

    /**
     * Creates a RecommendationAlgorithm object.
     *
     * @param user       The user for whom courses need to be recommended.
     * @param courseList The list of all available courses to choose from.
     */
    public ViewCourseData(User user, List<Course> courseList) {
        super(user, courseList);
    }


    /**
     * return the course associated with courseCode
     * @param courseCode: String
     * @return Course
     */
    public Course getCourseData(String courseCode) {
        return this.user.getSelectedCourses().get(courseCode);
    }
}
