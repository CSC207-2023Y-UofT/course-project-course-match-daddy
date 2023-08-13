package com.example.coursematchdaddy;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.user_subclasses.LoggedInUser;
import com.example.coursematchdaddy.clean_architecture_layers.gateways.classes.UserDB;
import com.example.coursematchdaddy.clean_architecture_layers.presenters.classes.CarouselPresenter;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CarouselPresenterTest {

    @Test
    public void testGetRecommendations() {
        User user = new LoggedInUser("abc", "email", "password");
        UserDB userDB = new UserDB();
        userDB.updateUserData(user);

        CarouselPresenter carouselPresenter = new CarouselPresenter("abc");
        List<Course> list = carouselPresenter.getRecommendations();
        Assert.assertNotNull(list);
    }

    @Test
    public void testUpdate() {
        User user = new LoggedInUser("abc", "email", "password");
        UserDB userDB = new UserDB();
        userDB.updateUserData(user);

        CarouselPresenter carouselPresenter = new CarouselPresenter("abc");
        List<Course> list = carouselPresenter.getRecommendations();
        carouselPresenter.update(true);
        Assert.assertNotNull(user.getSelectedCourses());
        carouselPresenter.update(false);
        Assert.assertNotNull(list);
    }
}