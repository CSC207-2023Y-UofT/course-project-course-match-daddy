package com.example.coursematchdaddy.clean_architecture_layers.entities.interfaces.course_class_imports_implementations;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;

public interface ClosedEnrollmentCourseInterface {

    /**
     * Enroll user into this course if they have met the prerequisites and the course has seats
     * available
     * @param userData: User
     * @return boolean
     */
    boolean enroll(User userData);

    /**
     * unenroll a student from this course
     * @param userData
     * @return boolean
     */
    boolean unenroll(User userData);
}
