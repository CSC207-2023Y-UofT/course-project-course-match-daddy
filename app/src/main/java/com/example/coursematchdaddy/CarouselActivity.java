package com.example.coursematchdaddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.coursematchdaddy.clean_architecture_layers.controllers.classes.CarouselController;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.presenters.classes.CarouselPresenter;

import java.util.List;

public class CarouselActivity extends AppCompatActivity {
    private List<Course> recommendedCourses;
    private int currentCourseIndex;

    private ImageView courseImageView;
    private TextView courseTitleTextView;
    private Button buttonCheck;
    private Button buttonReject;

    private CarouselPresenter presenter;
    private CarouselController controller;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carousel);

        //Get the username of the Logged in User
        // Get the username from the Intent extras
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("username")) {
            String username = intent.getStringExtra("username");

        recommendedCourses = presenter.getRecommendations(username);

        // Initialize the UI elements
        courseImageView = findViewById(R.id.imageView);
        courseTitleTextView = findViewById(R.id.textView4);
        buttonCheck = findViewById(R.id.buttonCheck);
        buttonReject = findViewById(R.id.buttonReject);
    }
}
