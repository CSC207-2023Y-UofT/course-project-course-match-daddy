package com.example.coursematchdaddy.clean_architecture_layers.presenters.classes;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Survey;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.user_subclasses.LoggedInUser;
import com.example.coursematchdaddy.clean_architecture_layers.gateways.classes.GETCourseGateway;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.RecommendationAlgorithm;

import java.util.List;

public class CarouselPresenter {
    private RecommendationAlgorithm recommendationAlgorithm;
    private List<Course> courseList;
    private GETCourseGateway gw;

    public CarouselPresenter(LoggedInUser loggedInUser) {
        gw = new GETCourseGateway();
        recommendationAlgorithm = new RecommendationAlgorithm(loggedInUser, gw.getCoursesListData() );
    }
    public List<Course> getRecommendations(String username){

        List<Course> recs = recommendationAlgorithm.getCourses(loggedInUser.getUserSurveyData(), loggedInUser);
        courseList = recs;
        return recs;
    }

    public void update(boolean action){
        if(action){
            courseList.remove(0);
        }
    }
}
