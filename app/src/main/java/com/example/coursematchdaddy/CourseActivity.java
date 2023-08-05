package com.example.coursematchdaddy;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.course_subclasses.ArtsAndSciencesCourse;
import com.example.coursematchdaddy.clean_architecture_layers.gateways.classes.UserDB;
import com.example.coursematchdaddy.clean_architecture_layers.presenters.classes.CoursePresenter;

import java.util.ArrayList;
import java.util.HashMap;

public class CourseActivity extends AppCompatActivity implements RecycleViewInterface{
    private CoursePresenter presenter;
    private ArrayList<String> courseList = new ArrayList<>();

    private Button toCarousel, toProgram;
    private User currentUser;
    RecyclerView rv;
    OutputAdapter oa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        this.currentUser = populateUser();

//        this.currentUser.getSelectedCourses().put("HI", new ArtsAndSciencesCourse("HI", "HEY", "HI", "HYD", new HashMap<>()));
//        this.currentUser.getSelectedCourses().put("sup", new ArtsAndSciencesCourse("ttt", "HEY", "HI", "HYD", new HashMap<>()));

        presenter = new CoursePresenter(new ArrayList<>(currentUser.getSelectedCourses().values()));

        toCarousel = (Button)findViewById(R.id.buttonCarousel);

        // moving to carousel on button click
        toCarousel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CourseActivity.this, CarouselActivity.class);
                intent.putExtra("username", getIntent().getStringExtra("username"));
                startActivity(intent);
                finish();
            }
        });

        toProgram = (Button)findViewById(R.id.buttonProgram);

        // moving to program tab on button click
        toProgram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CourseActivity.this, ProgramActivity.class);
                intent.putExtra("username", getIntent().getStringExtra("username"));
                startActivity(intent);
                finish();
            }
        });

        // for testing purposes
//        courseList.add("John");
//        courseList.add("Ranvir");
//        courseList.add("Uyiosa");
//        courseList.add("Uyiosa");
//        courseList.add("Uyiosa");
//        courseList.add("Uyiosa");
//        courseList.add("Uyiosa");
//        courseList.add("Uyiosa");
//        courseList.add("Uyiosa");
//        courseList.add("Uyiosa");

        for (HashMap<String, String> course : presenter.getCourseData()) {
            courseList.add(course.get("CourseTitle"));
        }

        rv = findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));
        oa = new OutputAdapter(courseList, this);
        rv.setAdapter(oa);
    }

    /**
     * Populate the user object given the username that was validated in the login screen
     * 
     * @return User object
     */
    private User populateUser() {
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");

        // temporarily taking the info directly from the database
        UserDB userDB = new UserDB();
        return userDB.getUserFromDB(username);
    }

    /**
     * update display information on click
     * @param pos
     */
    @Override
    public void onItemClick(int pos) {
        Log.d("PERSON", Integer.toString(pos));
        HashMap<String, String> selectedCourseData = presenter.getCourseData().get(pos);

        TextView tv1 = (TextView)findViewById(R.id.course_title);
        tv1.setText(selectedCourseData.get("CourseTitle"));

        TextView tv2 = (TextView)findViewById(R.id.course_code);
        tv2.setText(selectedCourseData.get("CourseCode"));

        TextView tv3 = (TextView)findViewById(R.id.course_description);
        tv3.setText(selectedCourseData.get("CourseDescription"));

        // code below is for testing
//        TextView tv1 = (TextView)findViewById(R.id.course_title);
//        tv1.setText("HI");
//
//        TextView tv2 = (TextView)findViewById(R.id.course_code);
//        tv2.setText("MY NAME IS DEV");
//
//        TextView tv3 = (TextView)findViewById(R.id.course_description);
//        tv3.setText("I LOVE CHEESE!");
    }
}
