package com.example.coursematchdaddy.clean_architecture_layers.controllers.classes;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Survey;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.user_subclasses.LoggedInUser;
import com.example.coursematchdaddy.clean_architecture_layers.gateways.classes.UserDB;
import com.example.coursematchdaddy.clean_architecture_layers.presenters.classes.CarouselPresenter;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.RecommendationAlgorithm;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.SwipeCarousel;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.updatesettings_subclasses.swipecarousel_subclasses.SwipeCardLeft;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.updatesettings_subclasses.swipecarousel_subclasses.SwipeCardRight;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.swipecarousel_class_imports_implementations.CollectCarouselSwipeInterface;

import java.util.List;

/**
 * Handles the interactions and actions for the CarouselActivity.
 * It communicates with the CarouselPresenter to update the recommended course list
 * and process user swipes.
 */
public class CarouselController{
    private User loggedInUser;
    private SwipeCardLeft swipeCardLeft;
    private SwipeCardRight swipeCardRight;
    private CarouselPresenter presenter;

    /**
     * Initialize the CarouselController.
     *
     * @param username The username of the logged-in user.
     */
    public CarouselController(String username) {
        UserDB userDB = new UserDB();
        User user = userDB.getUserFromDB(username);
        this.loggedInUser = user;
        // Create instances of SwipeCardLeft and SwipeCardRight
        swipeCardLeft = new SwipeCardLeft(loggedInUser);
        swipeCardRight = new SwipeCardRight(loggedInUser);
    }

    /**
     * Method to handle swipe left action.
     *
     * @param courseData The course data associated with the swiped card.
     */
    public void onSwipeLeft(Course courseData) {
       presenter.update(swipeCardLeft.processSwipe(courseData));
    }

    /**
     * Method to handle swipe right action.
     *
     * @param courseData The course data associated with the swiped card.
     */
    public void onSwipeRight(Course courseData){
        presenter.update(swipeCardRight.processSwipe(courseData));
    }
}
