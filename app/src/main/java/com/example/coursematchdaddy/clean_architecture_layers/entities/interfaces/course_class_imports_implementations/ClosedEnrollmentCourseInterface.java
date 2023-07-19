package com.example.coursematchdaddy.clean_architecture_layers.entities.interfaces.course_class_imports_implementations;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;

public interface ClosedEnrollmentCourseInterface {
    public boolean hasPrerequisites(User user);
    public boolean enroll(User user);
}
