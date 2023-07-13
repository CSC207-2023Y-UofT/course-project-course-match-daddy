package com.example.coursematchdaddy.clean_architecture_layers.entities.classes.course_subclasses;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;

public class ArtsAndSciencesCourse extends Course {



    public String getProgramArea() {
        return this.getMiscellaneousData.get("ProgramArea");
    }
    public String getBreadth() {
        return this.getMiscellaneousData.get("Breadth");
    }
    public String getDistribution() {
        return this.getMiscellaneousData.get("Distribution");
    }
    public int getRemainingSeats() {
        return this.getMiscellaneousData.get("RemainingSeats");
    }
    public boolean enroll(User userData) {
        if (this.getRemainingSeats() > 0) {
            // enroll user
            userData.getSelectedCourses().put(this.getCourseTitle(), this);
            // subtract from remaining seats
            this.getMiscellaneousData.put("RemainingSeats", this.getMiscellaneousData.
                    get("RemainingSeats") - 1);
        }
        return false;
    }
    public boolean unenroll(User userData) {
        this.getMiscellaneousData.put("RemainingSeats", this.getMiscellaneousData.
                get("RemainingSeats") + 1);
        return userData.getSelectedCourses().remove(this.getCourseTitle);
    }
}
