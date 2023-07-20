package com.example.coursematchdaddy.clean_architecture_layers.entities.interfaces.course_class_imports_implementations;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;

public interface ClosedEnrollmentCourseInterface {

    /**
     * Check if user has the prerequisite courses completed for this course
     * @param user: User
     * @return boolean
     */
    public boolean hasPrerequisites(User user);

    /**
     * Enroll user into this course if they have met the prerequisites and the course has seats
     * available
     * @param userData: User
     * @return boolean
     */
    public boolean enroll(User userData);
}
