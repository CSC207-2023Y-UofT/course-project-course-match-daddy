package com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes;

import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.swipecarousel_class_imports_implementations.CollectCarouselSwipeInterface;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.swipecarousel_class_imports_implementations.ExtractCourseDataInterface;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.swipecarousel_class_imports_implementations.ExtractProgramDataInterface;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.swipecarousel_class_imports_implementations.SwipeCardLeftInterface;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.swipecarousel_class_imports_implementations.SwipeCardRightInterface;

public abstract class SwipeCarousel implements ExtractCourseDataInterface, ExtractProgramDataInterface, SwipeCardRightInterface,
        SwipeCardLeftInterface, CollectCarouselSwipeInterface {
    private void getCourseRecommendations() {
    }
    public abstract void extractCourseData(ExtractCourseDataInterface extractor);
    public abstract void extractProgramData(ExtractProgramDataInterface extractor);
    public abstract boolean addCoursePreference(Course courseData);
    public abstract boolean removeCourseFromCarousel(SwipeCarousel carouselData, Course courseData);
}
}
