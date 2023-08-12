package com.example.coursematchdaddy;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.gateways.classes.UserDB;
import com.example.coursematchdaddy.clean_architecture_layers.presenters.classes.CoursePresenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CourseActivity extends AppCompatActivity implements RecycleViewInterface{
    private CoursePresenter presenter;
    private final ArrayList<String> courseList = new ArrayList<>();

    RecyclerView rv;
    OutputAdapter oa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        User currentUser = populateUser();


        presenter = new CoursePresenter((HashMap<String, Course>) currentUser.getSelectedCourses());

        Button toCarousel = (Button) findViewById(R.id.buttonCarousel);
        Log.d("LOG", "==================== " + currentUser.getSelectedCourses().values().size());

        // moving to carousel on button click
        toCarousel.setOnClickListener(view -> {
            Intent intent = new Intent(CourseActivity.this, CarouselActivity.class);
            intent.putExtra("username", getIntent().getStringExtra("username"));
            startActivity(intent);
            finish();
        });

        Button toProgram = (Button) findViewById(R.id.buttonProgram);

        // moving to program tab on button click
        toProgram.setOnClickListener(view -> {
            Intent intent = new Intent(CourseActivity.this, ProgramActivity.class);
            intent.putExtra("username", getIntent().getStringExtra("username"));
            startActivity(intent);
            finish();
        });

        for (Course c : presenter.getCourseData().values()) {
            courseList.add(c.getCourseTitle());
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
     * @param pos position
     */
    @Override
    public void onItemClick(int pos) {
//        Log.d("LOG", presenter.getCourseData().values())
        Log.d("PERSON", Integer.toString(pos));
        List<Course> courses = new ArrayList<>(presenter.getCourseData().values());
        Course selectedCourseData = courses.get(pos);

        TextView tv1 = (TextView)findViewById(R.id.course_title);
        tv1.setText(selectedCourseData.getCourseTitle());

        TextView tv2 = (TextView)findViewById(R.id.course_code);
        tv2.setText(selectedCourseData.getCourseCode());

        TextView tv3 = (TextView)findViewById(R.id.course_description);
        tv3.setText(selectedCourseData.getCourseDescription());

        TextView tv7 = (TextView)findViewById(R.id.textView7);
        //Remove textview
        if (tv7 != null) {
            ViewGroup parentView = (ViewGroup) tv7.getParent();
            if (parentView != null) {
                parentView.removeView(tv7);
            }
        }
    }
}
