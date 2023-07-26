package com.example.coursematchdaddy.clean_architecture_layers.entities.interfaces.course_class_imports_implementations;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;

public interface ArtsAndSciencesCourseInterface {

    /**
     * enroll a User into this course if there are seats available
     * @param userData: User
     * @return boolean
     */
    public boolean enroll(User userData);

    /**
     * unenroll a student from this course
     * @param userData
     * @return boolean
     */
    public boolean unenroll(User userData);
}