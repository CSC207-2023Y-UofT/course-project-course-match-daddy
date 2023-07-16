package com.example.coursematchdaddy.clean_architecture_layers.entities.classes.course_subclasses;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;

public class ArtsAndSciencesCourse extends Course {
    public boolean enroll(User userData) {
        if (this.getRemainingSeats() > 0) {
            // enroll user
            userData.getSelectedCourses().put(this.getCourseTitle(), this);
            // subtract from remaining seats
            this.getMiscellaneousCourseData.put("RemainingSeats", this.getMiscellaneousCourseData.
                    get("RemainingSeats") - 1);
        }
        return false;
    }
}
