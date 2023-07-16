package com.example.coursematchdaddy.clean_architecture_layers.entities.classes.course_subclasses;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;

import java.util.ArrayList;
import java.util.Map;

public class ClosedEnrollmentCourse extends Course {
    public boolean meetsPrerequisites(User user) {
        return this.getMiscellaneousCourseData.get("PrerequisitesMet");
    }
    public boolean enroll(User userData) {
        // if prerequisites are met and seats are available
        if (meetsPrerequisites(userData) && getRemainingSeats() > 0) {
            // enroll user
            userData.getSelectedCourses().put(getCourseTitle(), this);
            // subtract from remaining seats
            updateSeats(-1);
            return true;
        }
        return false;
    }
    private void updateSeats(int amount) {
        this.getMiscellaneousCourseData.put("RemainingSeats", this.getMiscellaneousCourseData.
                get("RemainingSeats") + amount);
    }
}
