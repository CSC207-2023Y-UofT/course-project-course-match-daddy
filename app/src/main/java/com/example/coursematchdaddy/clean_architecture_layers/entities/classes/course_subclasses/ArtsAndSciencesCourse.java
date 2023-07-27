package com.example.coursematchdaddy.clean_architecture_layers.entities.classes.course_subclasses;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;

public class ArtsAndSciencesCourse extends Course {

    /**
     * enroll a User into this course if there are seats available
     * @param userData: User
     * @return boolean
     */
    public boolean enroll(User userData) {
        if (this.getRemainingSeats() > 0) {
            // enroll user
            userData.getSelectedCourses().put(this.getCourseTitle(), this);
            // subtract from remaining seats
            updateSeats(-1);
        }
        return false;
    }

    /**
     * unenroll a student from this course
     * @param userData
     * @return boolean
     */
    public boolean unenroll(User userData) {
        try {
            // incrementing this course's seats by 1
            this.getMiscellaneousCourseData().put("RemainingSeats", getRemainingSeats() + 1);

            if (userData.getSelectedCourses().remove(this.getCourseTitle()) != null) {
                return true;
            }
            return false;

        } catch (NullPointerException e) {
            return false;
        }
    }

    /**
     * update the number of seats in this course by amount
     * @param amount: int
     */
    private void updateSeats(int amount) {
        // update the seats by adding in the amount to the RemainingSeats key-pair in misc data
        this.getMiscellaneousCourseData.put("RemainingSeats", this.getMiscellaneousCourseData.
                get("RemainingSeats") + amount);
    }
}
