package com.example.coursematchdaddy.clean_architecture_layers.controllers.classes;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Survey;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.user_subclasses.LoggedInUser;
import com.example.coursematchdaddy.clean_architecture_layers.presenters.classes.CarouselPresenter;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.RecommendationAlgorithm;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.SwipeCarousel;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.updatesettings_subclasses.swipecarousel_subclasses.SwipeCardLeft;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.updatesettings_subclasses.swipecarousel_subclasses.SwipeCardRight;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.swipecarousel_class_imports_implementations.CollectCarouselSwipeInterface;

import java.util.List;

public class CarouselController{
    private LoggedInUser loggedInUser;
    private SwipeCardLeft swipeCardLeft;
    private SwipeCardRight swipeCardRight;
    private CarouselPresenter presenter;

    public CarouselController(LoggedInUser loggedInUser) {
        this.loggedInUser = loggedInUser;
        // Create instances of SwipeCardLeft and SwipeCardRight
        swipeCardLeft = new SwipeCardLeft(loggedInUser);
        swipeCardRight = new SwipeCardRight(loggedInUser);
    }

    // Method to handle swipe left action
    public void onSwipeLeft(Course courseData) {
       presenter.update(swipeCardLeft.processSwipe(courseData));
    }
    public void onSwipeRight(Course courseData){
        presenter.update(swipeCardRight.processSwipe(courseData));
    }
}
