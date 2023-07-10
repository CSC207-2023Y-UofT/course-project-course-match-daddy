package com.example.coursematchdaddy.clean_architecture_layers.entities.classes;

import java.util.HashMap;

public class Course {
    private String courseTitle;
    private String courseCode;
    private String courseDescription;
    private String courseImageURL;
    private HashMap<String, Object> miscellaneousCourseData;
    public Course(String courseTitle, String courseCode,
                  String courseDescription, String courseImageURL,
                  HashMap<String, Object> miscellaneousCourseData) {
        this.courseTitle = courseTitle;
        this.courseCode = courseCode;
        this.courseDescription = courseDescription;
        this.courseImageURL = courseImageURL;
        this.miscellaneousCourseData = miscellaneousCourseData;
    }

    public String getCourseTitle() {
        return this.courseTitle;
    }
    public String getCourseCode() {
        return this.courseCode;
    }
    public String getCourseDescription() {
        return this.courseDescription;
    }
    public String getCourseImageURL() {
        return this.courseImageURL;
    }
    public HashMap<String, Object> getMiscellaneousCourseData() {
        return this.miscellaneousCourseData;
    }


}