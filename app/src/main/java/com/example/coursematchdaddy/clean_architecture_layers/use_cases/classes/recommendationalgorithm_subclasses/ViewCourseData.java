package com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.recommendationalgorithm_subclasses;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.RecommendationAlgorithm;

public class ViewCourseData extends RecommendationAlgorithm {
    /**
     * return the course associated with courseCode
     * @param courseCode: String
     * @return Course
     */
    public Course getCourseData(String courseCode) {
        for (Course c: this.user.getSelectedCourses()) {
            if (c.getCourseCode() == courseCode) {
                return c;
            }
        }
    }
}
