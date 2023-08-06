package com.example.coursematchdaddy.clean_architecture_layers.presenters.classes;

import android.util.Log;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.gateways.classes.GETCourseGateway;
import com.example.coursematchdaddy.clean_architecture_layers.gateways.classes.UserDB;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.RecommendationAlgorithm;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.recommendationalgorithm_subclasses.ExtractCoursesRecommendations;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.login_class_imports_implementations.CreateUserAccountInterface;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.login_class_imports_implementations.ExtractUserDataInterface;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.recommendationalgorithm_class_imports_implementations.ExtractCoursesRecommendationsInterface;

import java.util.List;

/**
 * Responsible for handling the business logic related to the CarouselActivity.
 * It communicates with the GETCourseGateway and ExtractCoursesRecommendationInterface to provide a list of
 * recommended courses to be displayed in the carousel.
 */
public class CarouselPresenter {
    private ExtractCoursesRecommendationsInterface recommendationAlgorithm;//interface implemented by <RecommendationAlgorithm>
    private List<Course> courseList;
    private GETCourseGateway gw;

    private User user;
    private ExtractUserDataInterface db;
    private CreateUserAccountInterface saveSwipe;

    /**
     * Initialize the CarouselPresenter.
     *
     * @param username The username of the logged-in user.
     */
    public CarouselPresenter(String username) {
        this.gw = new GETCourseGateway();
        this.db = new UserDB();//TODO: Consider passing this in through constructor
        this.user = db.getUserFromDB(username);
        recommendationAlgorithm = new ExtractCoursesRecommendations(user, gw.getCoursesListData() );
        courseList = recommendationAlgorithm.getCourseRecommendations();
        this.saveSwipe = new UserDB();//TODO: Consider passing this in through constructor
    }

    public List<Course> getRecommendations(String username){
        List<Course> recs = recommendationAlgorithm.getCourseRecommendations();
        courseList = recs;
        return recs;
    }

    /**
     * Update the course list based on the user's action.
     *
     * @param action True if the user swiped right, false if swiped left.
     */
    public void update(boolean action){
        if(action){
            //Add course to users selected courses and save their swipe
            Course selectedCourse = courseList.remove(0);
            this.user.getSelectedCourses().put(selectedCourse.getCourseTitle(), selectedCourse);
            saveSwipe.updateUserData(this.user);
        }else{
            courseList.remove(0);//simply remove the course.
        }
    }
}
