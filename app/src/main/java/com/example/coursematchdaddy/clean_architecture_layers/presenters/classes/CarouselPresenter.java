package com.example.coursematchdaddy.clean_architecture_layers.presenters.classes;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Survey;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.user_subclasses.LoggedInUser;
import com.example.coursematchdaddy.clean_architecture_layers.gateways.classes.GETCourseGateway;
import com.example.coursematchdaddy.clean_architecture_layers.gateways.classes.UserDB;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.RecommendationAlgorithm;

import java.util.List;

public class CarouselPresenter {
    private RecommendationAlgorithm recommendationAlgorithm;
    private List<Course> courseList;
    private GETCourseGateway gw;

    private User user;

    public CarouselPresenter(String username) {
        gw = new GETCourseGateway();
        UserDB userDB = new UserDB();
        User user = userDB.getUserFromDB(username);
        recommendationAlgorithm = new RecommendationAlgorithm(user, gw.getCoursesListData() );
    }
    public List<Course> getRecommendations(String username){
        List<Course> recs = recommendationAlgorithm.getCourses();
        courseList = recs;
        return recs;
    }

    public void update(boolean action){
        if(action){
            courseList.remove(0);
        }
    }
}
