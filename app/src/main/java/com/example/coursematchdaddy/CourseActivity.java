package com.example.coursematchdaddy;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursematchdaddy.clean_architecture_layers.controllers.classes.LoginController;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.course_subclasses.ArtsAndSciencesCourse;
import com.example.coursematchdaddy.clean_architecture_layers.gateways.classes.UserDB;
import com.example.coursematchdaddy.clean_architecture_layers.presenters.classes.CoursePresenter;
import com.example.coursematchdaddy.clean_architecture_layers.presenters.classes.LoginPresenter;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.Login;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseActivity extends AppCompatActivity implements RecycleViewInterface{
    private CoursePresenter presenter;
    private ArrayList<String> courseList = new ArrayList<>();
    private User currentUser;
    RecyclerView rv;
    OutputAdapter oa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        this.currentUser = populateUser();
        presenter = new CoursePresenter(new ArrayList<>(currentUser.getSelectedCourses().values()));

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
        
        for (Course c : presenter.getCourseList()) {
            courseList.add(presenter.getCourseData(c).get("CourseTitle"));
        }

        rv = findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));
        oa = new OutputAdapter(courseList, this);
        rv.setAdapter(oa);
    }



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
        HashMap<String, String> selectedCourseData = (HashMap<String, String>)presenter.getCourseData(courseList.get(pos));

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
