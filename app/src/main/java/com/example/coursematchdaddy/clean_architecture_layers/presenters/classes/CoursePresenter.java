package com.example.coursematchdaddy.clean_architecture_layers.presenters.classes;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.recommendationalgorithm_class_imports_implementations.ViewCourseDataInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoursePresenter implements ViewCourseDataInterface {
    private HashMap<String, Course> courseList;


    /**
     * @param courseList Course list1
     */
<<<<<<< HEAD
    public CoursePresenter(HashMap<String,Course> courseList) {
        this.courseList = courseList;
=======
    public CoursePresenter(List<Course> courses) {
        for (Course course : courses) {
            HashMap<String, String> courseData = new HashMap<>();
            courseData.put("CourseTitle", course.getCourseTitle());
            courseData.put("CourseCode", course.getCourseCode());
            courseData.put("CourseDescription", course.getCourseDescription());
            courseList.add(courseData);
        }
>>>>>>> main
    }


    /**
     * return course map containing course titles, codes, and descriptions
     *
     * @return Map < String, String>
     */
    @Override
    public HashMap<String, Course> getCourseData() {
        return courseList;
    }
}
