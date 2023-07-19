package com.example.coursematchdaddy.clean_architecture_layers.entities.classes;

import java.util.HashMap;

public abstract class Course {
    private String courseTitle;
    private String courseCode;
    private String courseDescription;
    private String courseImageURL;
    private HashMap<String, Object> miscellaneousCourseData;

    /**
     * @param courseTitle
     * @param courseCode
     * @param courseDescription
     * @param courseImageURL
     * @param miscellaneousCourseData
     */
    public Course(String courseTitle, String courseCode,
                  String courseDescription, String courseImageURL,
                  HashMap<String, Object> miscellaneousCourseData) {
        this.courseTitle = courseTitle;
        this.courseCode = courseCode;
        this.courseDescription = courseDescription;
        this.courseImageURL = courseImageURL;
        this.miscellaneousCourseData = miscellaneousCourseData;
    }

    /**
     * return course title (ex. Introduction to Computer Science)
     * @return
     */
    public String getCourseTitle() {
        return this.courseTitle;
    }

    /**
     * return course code (ex. CSC148)
     * @return
     */
    public String getCourseCode() {
        return this.courseCode;
    }

    /**
     * return course description (ex. This course introduces students to...)
     * @return
     */
    public String getCourseDescription() {
        return this.courseDescription;
    }

    /**
     * return course image URL
     * @return
     */
    public String getCourseImageURL() {
        return this.courseImageURL;
    }

    /**
     * return miscellaneous course data (in key-pair format)
     * @return
     */
    public HashMap<String, Object> getMiscellaneousCourseData() {
        return this.miscellaneousCourseData;
    }

    /**
     * return program area of this course (ex. Computer Science)
     * @return
     */
    public String getProgramArea() {
        return (String)this.getMiscellaneousCourseData().get("ProgramArea");
    }

    /**
     * return breadth (ex. The Physical and Mathematical Universes (5))
     * @return
     */
    public String getBreadth() {
        return (String)this.getMiscellaneousCourseData().get("Breadth");
    }

    /**
     * return distribution (ex. Science)
     * @return
     */
    public String getDistribution() {
        return (String)this.getMiscellaneousCourseData().get("Distribution");
    }

    /**
     * return seats available in this course
     * @return
     */
    public int getRemainingSeats() {
        try {
            // find seats from misc data
            int seats = (int)this.getMiscellaneousCourseData().get("RemainingSeats");
            return seats;
        } catch (NullPointerException e) {
            // course cannot be enrolled in
            return 0;
        }
    }

    /**
     * enroll a user into a course
     * @param userData
     * @return
     */
    public abstract boolean enroll(User userData);

    /**
     * unenroll a student from this course
     * @param userData
     * @return
     */
    public boolean unenroll(User userData) {
        try {
            // incrementing this course's seats by 1
            this.getMiscellaneousCourseData().put("RemainingSeats", getRemainingSeats() + 1);

            // removing this course from the user's selected courses
            return userData.getSelectedCourses().remove(this.getCourseTitle);

        } catch (NullPointerException e) {
            return false;
        }
    }
}