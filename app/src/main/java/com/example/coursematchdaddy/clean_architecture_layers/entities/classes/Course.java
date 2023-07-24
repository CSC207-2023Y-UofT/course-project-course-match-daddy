package com.example.coursematchdaddy.clean_architecture_layers.entities.classes;

import java.util.HashMap;

public abstract class Course {
    private final String courseTitle;
    private final String courseCode;
    private final String courseDescription;
    private final String courseImageURL;
    private final HashMap<String, Object> miscellaneousCourseData;

    /**
     * @param courseTitle: String
     * @param courseCode: String
     * @param courseDescription: String
     * @param courseImageURL: String
     * @param miscellaneousCourseData: HashMap<String, Object>
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
     * @return String
     */
    public String getCourseTitle() {
        return this.courseTitle;
    }

    /**
     * return course code (ex. CSC148)
     * @return String
     */
    public String getCourseCode() {
        return this.courseCode;
    }

    /**
     * return course description (ex. This course introduces students to...)
     * @return String
     */
    public String getCourseDescription() {
        return this.courseDescription;
    }

    /**
     * return course image URL
     * @return String
     */
    public String getCourseImageURL() {
        return this.courseImageURL;
    }

    /**
     * return miscellaneous course data (in key-pair format)
     * @return HashMap<String, Object>
     */
    public HashMap<String, Object> getMiscellaneousCourseData() {
        return this.miscellaneousCourseData;
    }

    /**
     * return program area of this course (ex. Computer Science)
     * @return String
     */
    public String getProgramArea() {
        return (String)this.getMiscellaneousCourseData().get("ProgramArea");
    }

    /**
     * return breadth (ex. The Physical and Mathematical Universes (5))
     * @return String
     */
    public String getBreadth() {
        return (String)this.getMiscellaneousCourseData().get("Breadth");
    }

    /**
     * return distribution (ex. Science)
     * @return String
     */
    public String getDistribution() {
        return (String)this.getMiscellaneousCourseData().get("Distribution");
    }

    /**
     * return seats available in this course
     * @return int
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
     * @return boolean
     */
    public abstract boolean enroll(User userData);

    /**
     * unenroll a student from this course
     * @param userData
     * @return boolean
     */
    public abstract boolean unenroll(User userData);
}