package com.example.coursematchdaddy.clean_architecture_layers.entities.interfaces.course_class_imports_implementations;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;

public interface OpenEnrollmentCourseInterface {
    public String getProgramArea();
    public String getBreadth();
    public int getRemainingSeats();
    public String getDistribution();
    public boolean enroll(User user);
    public boolean unenroll(User user);

}
