package com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Program;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Survey;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.course_subclasses.ArtsAndSciencesCourse;
import com.example.coursematchdaddy.clean_architecture_layers.entities.interfaces.course_class_imports_implementations.ArtsAndSciencesCourseInterface;
import com.example.coursematchdaddy.clean_architecture_layers.entities.interfaces.course_class_imports_implementations.ClosedEnrollmentCourseInterface;
import com.example.coursematchdaddy.clean_architecture_layers.entities.interfaces.course_class_imports_implementations.OpenEnrollmentCourseInterface;
import com.example.coursematchdaddy.clean_architecture_layers.entities.interfaces.program_class_imports_implementations.Type1ProgramInterface;
import com.example.coursematchdaddy.clean_architecture_layers.entities.interfaces.program_class_imports_implementations.Type2ProgramInterface;
import com.example.coursematchdaddy.clean_architecture_layers.entities.interfaces.program_class_imports_implementations.Type3ProgramInterface;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class RecommendationAlgorithm implements ArtsAndSciencesCourseInterface, OpenEnrollmentCourseInterface, ClosedEnrollmentCourseInterface, Type1ProgramInterface, Type2ProgramInterface, Type3ProgramInterface {
    @Override
    public boolean hasPrerequisites(User user) {
        return false;
    }

    @Override
    public boolean enroll(User userData) {
        return false;
    }

    @Override
    public boolean hasSpace() {
        return false;
    }

    @Override
    public boolean enroll(User userData, boolean hasRequirements) {
        return false;
    }

    @Override
    public boolean unenroll(User userData) {
        return false;
    }

    //NOT ACTUALLY COMPLETE, ONLY RETURNS COURSES THEY HAVE TAKEN
    public List<Course> getCourses(Survey surveyData, User userData){

        List<String> courseTitles = surveyData.getCoursesTaken();
        List<Course> courseObjects = new ArrayList<>();

        // Create Course objects and add them to the list
        for (String title : courseTitles) {
            Course course = new ArtsAndSciencesCourse(
                    title,
                    "Code_" + title,
                    "Description for " + title,
                    "ImageURL_" + title,
                    new HashMap<>() // Empty HashMap for miscellaneousCourseData
            );
            courseObjects.add(course);
        }
        return courseObjects;
    }

    public List<Program> getPrograms(Survey surveyData, User userData){
        return (new ArrayList<Program>((Collection<? extends Program>) new Program("THIS", "IS NOT", "COMPLETE")));
    }
}
