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

/**
 * This activity displays a carousel of recommended courses.
 * The user can swipe left to reject a course or swipe right to like a course.
 * The activity uses a presenter and controller to handle the logic and interactions.
 */
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
                // Handle the user swiping right on the course
                onCourseAccepted();
            }
        });

        buttonReject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the user swiping left on the course
                onCourseRejected();
            }
        });

        // Display the first course in the carousel
        displayCourse(currentCourseIndex);
    }

    /**
     * This method will be called when the user swipes right on the course.
     * It removes the course from the list and updates the UI.
     * The process of removing and adding is done by the controller
     */
    private void onCourseAccepted() {
        // Remove the course from the list and update the UI
        carouselController.onSwipeRight(recommendedCourses.get(currentCourseIndex));
        recommendedCourses.remove(currentCourseIndex);
        displayCourse(currentCourseIndex);
    }

    /**
     * This method will be called when the user swipes left on the course.
     * It removes the course from the list and updates the UI.
     */
    private void onCourseRejected() {
        // Remove the course from the list and update the UI
        carouselController.onSwipeLeft(recommendedCourses.get(currentCourseIndex));
        recommendedCourses.remove(currentCourseIndex);
        displayCourse(currentCourseIndex);
    }

    /**
     * Method to display the course at the specified index.
     * It sets the image and title of the course.
     * If there are no more courses to display, it finishes the activity.
     *
     * @param index The index of the course to display (Always 0).
     */
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
            // Navigate to another activity
            finish();
        }
    }
}
