package com.example.coursematchdaddy.clean_architecture_layers.controllers.classes;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.gateways.classes.UserDB;
import com.example.coursematchdaddy.clean_architecture_layers.presenters.classes.CarouselPresenter;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.swipecarousel_subclasses.SwipeCardLeft;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.swipecarousel_subclasses.SwipeCardRight;

/**
 * Handles the interactions and actions for the CarouselActivity.
 * It communicates with the CarouselPresenter to update the recommended course list
 * and process user swipes.
 */
public class CarouselController{
    private final SwipeCardLeft swipeCardLeft;
    private final SwipeCardRight swipeCardRight;
    private final CarouselPresenter presenter;

    /**
     * Initialize the CarouselController.
     *
     * @param username The username of the logged-in user.
     */
    public CarouselController(String username) {
        UserDB userDB = new UserDB();
        User user = userDB.getUserFromDB(username); // Fetch the user data
        // Create instances of SwipeCardLeft and SwipeCardRight
        swipeCardLeft = new SwipeCardLeft(user);
        swipeCardRight = new SwipeCardRight(user);
        this.presenter = new CarouselPresenter(username); // Create instance of carousel presenter
    }

    /**
     * Method to handle swipe left action.
     *
     * @param courseData The course data associated with the swiped card.
     */
    public void onSwipeLeft(Course courseData) {
       // Call CarouselPresenter's update method with the result of swipeCardLeft's processSwipe 
       presenter.update(swipeCardLeft.processSwipe(courseData));
    }

    /**
     * Method to handle swipe right action.
     *
     * @param courseData The course data associated with the swiped card.
     */
    public void onSwipeRight(Course courseData){
        // Call CarouselPresenter's update method with the result of swipeCardRight's processSwipe
        presenter.update(swipeCardRight.processSwipe(courseData));
    }
}
