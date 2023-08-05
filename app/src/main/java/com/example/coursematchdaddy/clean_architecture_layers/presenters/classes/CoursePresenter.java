package com.example.coursematchdaddy.clean_architecture_layers.presenters.classes;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.recommendationalgorithm_class_imports_implementations.ViewCourseDataInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoursePresenter implements ViewCourseDataInterface {
    private List<HashMap<String, String>> courseList = new ArrayList<>();


    /**
     * @param c Course list
     */
    public CoursePresenter(List<Course> courses) {
        for (Course course : courses) {
            HashMap<String, String> courseData = new HashMap<>();
            courseData.put("CourseTitle", course.getCourseTitle());
            courseData.put("CourseCode", course.getCourseCode());
            courseData.put("courseDescription", course.getCourseDescription());
            courseList.add(courseData);
        }
    }


    /**
     * return a list of course maps containing course titles, codes, and descriptions
     *
     * @return List<Map < String, String>>
     */
    @Override
    public List<HashMap<String, String>> getCourseData() {
        return courseList;
    }
}
