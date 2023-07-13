package com.example.coursematchdaddy.clean_architecture_layers.entities.classes;

import java.util.HashMap;

public abstract class Course {
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
    public String getProgramArea() {
        return (String)this.getMiscellaneousCourseData().get("ProgramArea");
    }
    public String getBreadth() {
        return (String)this.getMiscellaneousCourseData().get("Breadth");
    }
    public String getDistribution() {
        return (String)this.getMiscellaneousCourseData().get("Distribution");
    }
    public int getRemainingSeats() {
        try {
            int seats = (int)this.getMiscellaneousCourseData().get("RemainingSeats");
            return seats;
        } catch (NullPointerException e) {
            return 0;
        }
    }
    public abstract boolean enroll(User userData);
    public boolean unenroll(User userData) {
        try {
            this.getMiscellaneousCourseData().put("RemainingSeats", (int)this.
                    getMiscellaneousCourseData().get("RemainingSeats") + 1);
        } catch (NullPointerException e) {
            return false;
        }
        return userData.getSelectedCourses().remove(this.getCourseTitle);
    }


}