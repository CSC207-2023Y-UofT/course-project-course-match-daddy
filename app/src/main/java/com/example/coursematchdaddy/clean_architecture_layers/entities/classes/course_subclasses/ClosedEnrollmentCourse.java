package com.example.coursematchdaddy.clean_architecture_layers.entities.classes.course_subclasses;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;

public class ClosedEnrollmentCourse extends Course {
    /**
     * Check if user has the prerequisite courses completed for this course
     * @param user
     * @return
     */
    public boolean hasPrerequisites(User user) {
        // placeholder method to show if prerequisites exist or not (will almost always return true)
        return this.getMiscellaneousCourseData.get("PrerequisitesMet") != "";
    }

    /**
     * Enroll user into this course if they have met the prerequisites and the course has seats
     * available
     * @param userData
     * @return
     */
    public boolean enroll(User userData) {
        // if user has prerequisites and seats are available
        if (hasPrerequisites(userData) && getRemainingSeats() > 0) {
            // enroll user
            userData.getSelectedCourses().put(getCourseTitle(), this);
            // subtract from remaining seats
            updateSeats(-1);
            return true;
        }
        return false;
    }

    /**
     * Update the course's seats by amount
     * @param amount
     */
    private void updateSeats(int amount) {
        // update the seats by adding in the amount to the RemainingSeats key-pair in misc data
        this.getMiscellaneousCourseData.put("RemainingSeats", this.getMiscellaneousCourseData.
                get("RemainingSeats") + amount);
    }
}
