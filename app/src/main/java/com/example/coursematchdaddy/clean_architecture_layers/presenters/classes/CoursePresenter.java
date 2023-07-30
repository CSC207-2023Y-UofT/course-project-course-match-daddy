package com.example.coursematchdaddy.clean_architecture_layers.presenters.classes;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.recommendationalgorithm_class_imports_implementations.ViewCourseDataInterface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoursePresenter implements ViewCourseDataInterface {
    private List<Course> courseList;


    /**
     * @param c Course list
     */
    public CoursePresenter(List<Course> c) {
        this.courseList = c;
    }

    /**
     * return the list of courses to be displayed
     * @return List<Course> list of courses
     */
    public List<Course> getCourseList() {
        return this.courseList;
    }

    /**
     * return the data associated with a selected course
     * @param courseCode Course code associated with a course
     * @return Map<String, String> the data that needs to be displayed
     */
    public Map<String, String> getCourseData(String courseCode) {
        // adding all data from the course with the same code as courseCode (String)
        HashMap<String, String> data = new HashMap<String, String>();
        for (Course c : courseList) {
            if (c.getCourseCode() == courseCode) {
                data.put("CourseCode", c.getCourseCode());
                data.put("CourseDescription", c.getCourseDescription());
                data.put("CourseTitle", c.getCourseTitle());
            }
        }
        return data;
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
            if (c.getCourseCode() == course.getCourseCode()) {
                data.put("CourseCode", c.getCourseCode());
                data.put("CourseDescription", c.getCourseDescription());
                data.put("CourseTitle", c.getCourseTitle());
            }
        }
        return data;
    }

}
