package com.example.coursematchdaddy.clean_architecture_layers.entities.interfaces.course_class_imports_implementations;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;

public interface ClosedEnrollmentCourseInterface {
    public boolean meetsPrerequisites(User user);
    public boolean enroll(User user);
    public boolean updateSeats(int amount);
}
