package com.example.coursematchdaddy;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

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

    private CarouselPresenter carouselPresenter;
    private CarouselController carouselController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carousel);

        // Get the username from the previous activity
        String username = getIntent().getStringExtra("username");

        // Initialize the presenter and controller
        carouselPresenter = new CarouselPresenter(username);
        carouselController = new CarouselController(username);

        // Get the recommended courses from the presenter
        recommendedCourses = carouselPresenter.getRecommendations(username);

        // Initialize the index to display the first course
        currentCourseIndex = 0;

        // Initialize the UI elements
        courseImageView = findViewById(R.id.imageView);
        courseTitleTextView = findViewById(R.id.textView4);
        buttonCheck = findViewById(R.id.buttonCheck);
        buttonReject = findViewById(R.id.buttonReject);

        // Set click listeners for the buttons
        buttonCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the user swiping right (accepting) the course
                onCourseAccepted();
            }
        });

        buttonReject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the user swiping left (rejecting) the course
                onCourseRejected();
            }
        });

        // Display the first course in the carousel
        displayCourse(currentCourseIndex);
    }

    // This method will be called when the user swipes right (accepting) the course
    private void onCourseAccepted() {
        // Remove the course from the list and update the UI
        carouselController.onSwipeRight(recommendedCourses.get(currentCourseIndex));
        recommendedCourses.remove(currentCourseIndex);
        displayCourse(currentCourseIndex);
    }

    // This method will be called when the user swipes left (rejecting) the course
    private void onCourseRejected() {
        // Remove the course from the list and update the UI
        carouselController.onSwipeLeft(recommendedCourses.get(currentCourseIndex));
        recommendedCourses.remove(currentCourseIndex);
        displayCourse(currentCourseIndex);
    }

    // Method to display the course at the specified index
    private void displayCourse(int index) {
        if (index >= 0 && index < recommendedCourses.size()) {
            Course currentCourse = recommendedCourses.get(index);
            // Set the image and title of the course
            String imagePath = currentCourse.getCourseImageURL();

            //Convert the imagePath to a bitmap
            Bitmap bitmap = BitmapFactory.decodeFile(imagePath);

            //Set the image using the bitmap
            courseImageView.setImageBitmap(bitmap);
            courseTitleTextView.setText(currentCourse.getCourseTitle());
        } else {
            // Handle the case when there are no more courses to display
            // For example, show a message like "No more courses to display"
            // or navigate to another activity
            finish();
        }
    }
}
