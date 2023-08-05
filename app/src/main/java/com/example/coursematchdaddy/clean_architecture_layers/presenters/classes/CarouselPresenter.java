package com.example.coursematchdaddy.clean_architecture_layers.presenters.classes;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Survey;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.user_subclasses.LoggedInUser;
import com.example.coursematchdaddy.clean_architecture_layers.gateways.classes.GETCourseGateway;
import com.example.coursematchdaddy.clean_architecture_layers.gateways.classes.UserDB;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.RecommendationAlgorithm;

import java.util.List;

/**
 * Responsible for handling the business logic related to the CarouselActivity.
 * It communicates with the GETCourseGateway and RecommendationAlgorithm to provide a list of
 * recommended courses to be displayed in the carousel.
 */
public class CarouselPresenter {
    private RecommendationAlgorithm recommendationAlgorithm;
    private List<Course> courseList;
    private GETCourseGateway gw;

    private User user;

    /**
     * Initialize the CarouselPresenter.
     *
     * @param username The username of the logged-in user.
     */
    public CarouselPresenter(String username) {
        gw = new GETCourseGateway();
        UserDB userDB = new UserDB();
        User user = userDB.getUserFromDB(username);
        recommendationAlgorithm = new RecommendationAlgorithm(user, gw.getCoursesListData());
        courseList = recommendationAlgorithm.getCourses();
    }

    public List<Course> getRecommendations(String username){
        return courseList;
    }

    /**
     * Update the course list based on the user's action.
     *
     * @param action True if the user swiped right, false if swiped left.
     */
    public void update(boolean action){
        if(action){
            courseList.remove(0);
        }
    }
}
