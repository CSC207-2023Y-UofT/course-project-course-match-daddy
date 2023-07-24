package com.example.coursematchdaddy.clean_architecture_layers.presenters.classes;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.recommendationalgorithm_class_imports_implementations.ViewCoursesRecommendationsInterface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class CourseRecommendationsPresenter implements ViewCoursesRecommendationsInterface {

    private List<Course> courseList;
    public CourseRecommendationsPresenter(List<Course> c) {
        this.courseList = c;
    }

    /**
     * returning the course recommendations for a given user
     * @param userData the user who's courses are to be determined
     * @return List<Course> a list of courses to display
     */
    public List<Course> getCourseRecommendations(User userData) {
        // TEMPORARILY RETURNING THE COURSE LIST ONLY
        return this.courseList;
    }

    /**
     * return the data associated with a selected course
     * @param course Course object that is selected
     * @return Map<String, String> the data that needs to be displayed
     */
    public Map<String, String> getCourseData(Course course) {
        // adding all data from the course matching with course (Course object)
        HashMap<String, String> data = new HashMap<String, String>();
        for (Course c : courseList) {
            if (Objects.equals(c.getCourseCode(), course.getCourseCode())) {
                data.put("CourseCode", c.getCourseCode());
                data.put("CourseDescription", c.getCourseDescription());
                data.put("CourseTitle", c.getCourseTitle());
                data.put("CourseImageURL", c.getCourseTitle());
            }
        }
        return data;
    }
}
