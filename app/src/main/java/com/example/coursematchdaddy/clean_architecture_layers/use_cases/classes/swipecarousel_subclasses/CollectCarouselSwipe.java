package com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.swipecarousel_subclasses;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Program;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.SwipeCarousel;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.swipecarousel_class_imports_implementations.ExtractCourseDataInterface;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.swipecarousel_class_imports_implementations.ExtractProgramDataInterface;

import java.util.HashMap;

public class CollectCarouselSwipe extends SwipeCarousel {
    @Override
    public void extractCourseData(ExtractCourseDataInterface extractor) {

    }

    @Override
    public void extractProgramData(ExtractProgramDataInterface extractor) {

    }

    @Override
    public boolean addCoursePreference(Course courseData) {
        return false;
    }

    @Override
    public boolean removeCourseFromCarousel(SwipeCarousel carouselData, Course courseData) {
        return false;
    }

    @Override
    public String collectCarouselSwipe() {
        return null;
    }

    @Override
    public String getCourseTitle(Course courseData) {
        return null;
    }

    @Override
    public String getCourseCode(Course courseData) {
        return null;
    }

    @Override
    public String getCourseDescription(Course courseData) {
        return null;
    }

    @Override
    public String getImageURL(Course courseData) {
        return null;
    }

    @Override
    public HashMap<String, Object> getMiscellaneousCourseData(Course courseData) {
        return null;
    }

    @Override
    public String getTitle(Program programData) {
        return null;
    }

    @Override
    public String getCode(Program programData) {
        return null;
    }

    @Override
    public String getDescription(Program programData) {
        return null;
    }
}
