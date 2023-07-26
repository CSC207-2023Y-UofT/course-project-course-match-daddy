package com.example.coursematchdaddy;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.presenters.classes.CoursePresenter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseActivity extends AppCompatActivity implements RecycleViewInterface{
    private CoursePresenter presenter;
    private ArrayList<String> courseList = new ArrayList<>();
    RecyclerView rv;
    OutputAdapter oa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

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

        for (Course c : getCourseList()) {
            courseList.add(getCourseData(c).get(""));
        }

        rv = findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));
        oa = new OutputAdapter(courseList, this);
        rv.setAdapter(oa);
    }

    /**
     * Set the presenter of this activity
     * @param cp: the Course Presenter
     */
    public void setPresenter(CoursePresenter cp) {
        this.presenter = cp;
    }

    /**
     * return the list of courses to be displayed
     * @return List<Course> list of courses
     */
    public List<Course> getCourseList() {
        return presenter.getCourseList();
    }

    /**
     * return the data associated with a selected course
     * @param courseCode Course code associated with a course
     * @return Map<String, String> the data that needs to be displayed
     */
    public Map<String, String> getCourseData(String courseCode) {
        return presenter.getCourseData(courseCode);
    }

    /**
     * return the data associated with a selected course
     * @param course Course object that is selected
     * @return Map<String, String> the data that needs to be displayed
     */
    public Map<String, String> getCourseData(Course course) {
        return presenter.getCourseData(course);
    }

    /**
     * update display information on click
     * @param pos
     */
    @Override
    public void onItemClick(int pos) {
        Log.d("PERSON", Integer.toString(pos));
        HashMap<String, String> selectedCourseData = (HashMap<String, String>)getCourseData(courseList.get(pos));

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
