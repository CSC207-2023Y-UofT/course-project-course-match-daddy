package com.example.coursematchdaddy.clean_architecture_layers.entities.classes.course_subclasses;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;

public class ClosedEnrollmentCourse extends Course {
<<<<<<< Updated upstream
=======
    /**
     * @param courseTitle             : String
     * @param courseCode              : String
     * @param courseDescription       : String
     * @param courseImageURL          : String
     * @param miscellaneousCourseData : HashMap<String, Object>
     */
    public ClosedEnrollmentCourse(String courseTitle, String courseCode, String courseDescription, String courseImageURL, HashMap<String, Object> miscellaneousCourseData) {
        super(courseTitle, courseCode, courseDescription, courseImageURL, miscellaneousCourseData);
    }

    /**
     * Check if user has the prerequisite courses completed for this course
     * @param user: User
     * @return boolean
     */
    public boolean hasPrerequisites(User user) {
        // placeholder method to show if prerequisites exist or not (will almost always return true)
        return this.getMiscellaneousCourseData.get("PrerequisitesMet") != "";
    }

    /**
     * Enroll user into this course if they have met the prerequisites and the course has seats
     * available
     * @param userData: User
     * @return boolean
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
     * unenroll a student from this course
     * @param userData
     * @return boolean
     */
    public boolean unenroll(User userData) {
        try {
            // incrementing this course's seats by 1
            this.getMiscellaneousCourseData().put("RemainingSeats", getRemainingSeats() + 1);

            // removing this course from the user's selected courses
            if (userData.getSelectedCourses().remove(this.getCourseTitle()) != null) {
                return true;
            }
            return false;

        } catch (NullPointerException e) {
            return false;
        }
    }

    /**
     * Update the course's seats by amount
     * @param amount: int
     */
    private void updateSeats(int amount) {
        // update the seats by adding in the amount to the RemainingSeats key-pair in misc data
        this.getMiscellaneousCourseData.put("RemainingSeats", this.getMiscellaneousCourseData.
                get("RemainingSeats") + amount);
    }
>>>>>>> Stashed changes
}
