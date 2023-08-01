package com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.updatesettings_subclasses.swipecarousel_subclasses;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Program;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Survey;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.user_subclasses.LoggedInUser;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.SwipeCarousel;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.swipecarousel_class_imports_implementations.ExtractCourseDataInterface;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.swipecarousel_class_imports_implementations.ExtractProgramDataInterface;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.swipecarousel_class_imports_implementations.SwipeCardRightInterface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// The logic of this class is handled in the SwipeCarousel class
public class SwipeCardRight extends SwipeCarousel{
    public SwipeCardRight(User loggedInUser) {
        super(loggedInUser);
    }

    @Override
    public boolean processSwipe(Course courseData) {
        String courseString = courseData.getCourseTitle();
        Map<String, Course> courseMap = new HashMap<>();
        courseMap.put(courseString, courseData);
        loggedInUser.updateUserSelectedCourses(courseMap);
        return true;
    }
}
