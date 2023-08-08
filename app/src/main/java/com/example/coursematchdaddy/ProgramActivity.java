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
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Program;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.gateways.classes.GETCourseGateway;
import com.example.coursematchdaddy.clean_architecture_layers.gateways.classes.GETProgramGateway;
import com.example.coursematchdaddy.clean_architecture_layers.gateways.classes.UserDB;
import com.example.coursematchdaddy.clean_architecture_layers.presenters.classes.ProgramPresenter;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.recommendationalgorithm_subclasses.ExtractProgramsRecommendations;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.recommendationalgorithm_class_imports_implementations.ExtractProgramsRecommendationsInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProgramActivity extends AppCompatActivity implements RecycleViewInterface{
    private ProgramPresenter presenter;
    private ArrayList<String> programList = new ArrayList<>();

    private Button toCarousel, toCourse;
    private User currentUser;
    RecyclerView rv;
    OutputAdapter oa;

    /**
     * On creation of this activity
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program);

        // populate the user from the previous activity
        this.currentUser = populateUser();

//        currentUser.getSelectedPrograms().put("HI", new Program("HI", "HELLO", "HOW ARE YOU?"));
//        currentUser.getSelectedPrograms().put("HEY!", new Program("HEY!", "HELLO", "HOW ARE YOU?"));

//        Log.e("Program name:", currentUser.getSelectedPrograms());
        // put the program info into the presenter
        for (Program p : currentUser.getSelectedPrograms().values()) {
            Log.e("Program name:", p.getProgramTitle());
        }
        updateSelectedPrograms();
        presenter = new ProgramPresenter((HashMap<String, Program>) currentUser.getSelectedPrograms());

        toCarousel = (Button)findViewById(R.id.buttonCarousel);
        // moving to carousel on button click
        toCarousel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProgramActivity.this, CarouselActivity.class);
                intent.putExtra("username", getIntent().getStringExtra("username"));
                startActivity(intent);
                finish();
            }
        });

        toCourse = (Button)findViewById(R.id.buttonCourse);

        // moving to program tab on button click
        toCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProgramActivity.this, CourseActivity.class);
                intent.putExtra("username", getIntent().getStringExtra("username"));
                startActivity(intent);
                finish();
            }
        });

        // for testing purposes
//        programList.add("John");
//        programList.add("Ranvir");
//        programList.add("Uyiosa");
//        programList.add("Uyiosa");
//        programList.add("Uyiosa");
//        programList.add("Uyiosa");
//        programList.add("Uyiosa");
//        programList.add("Uyiosa");
//        programList.add("Uyiosa");
//        programList.add("Uyiosa");

        // add the programs to the program list

        for (Program p: presenter.getProgramList().values()) {
            programList.add(p.getProgramTitle());
        }

        rv = findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));
        oa = new OutputAdapter(programList, this);
        rv.setAdapter(oa);

        Button toCourse = (Button) findViewById(R.id.buttonProgram);//TODO: Change this id
        Button toCarousel = (Button)findViewById(R.id.buttonCarousel);
        // moving to program tab on button click
        toCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( ProgramActivity.this, CourseActivity.class);
                intent.putExtra("username", getIntent().getStringExtra("username"));
                startActivity(intent);
                finish();
            }
        });

        toCarousel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProgramActivity.this, CarouselActivity.class);
                intent.putExtra("username", getIntent().getStringExtra("username"));
                startActivity(intent);
                finish();
            }
        });
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

    private void updateSelectedPrograms(){

        //TODO: Make sure the following two lines adhere to CA, modify if they dont
        GETProgramGateway pgw = new GETProgramGateway();
        GETCourseGateway cgw = new GETCourseGateway();
        ExtractProgramsRecommendationsInterface ra = new ExtractProgramsRecommendations(this.currentUser, cgw.getCoursesListData(), pgw.getProgramsListData());
        HashMap<String, Program> programs = new HashMap<>();
        for (Program p: ra.getProgramRecommendations()){
            programs.put(p.getProgramTitle(), p);
        }
        this.currentUser.updateUserSelectedPrograms(programs);
    }

    /**
     * update display information on click
     * @param pos indicates the number of the box that is clicked (increases as you go down)
     */
    @Override
    public void onItemClick(int pos) {

        List<Program> programs = new ArrayList<>(presenter.getProgramData().values());
        Program selectedProgramData = programs.get(pos);

        TextView tv1 = (TextView)findViewById(R.id.program_title);
        tv1.setText(selectedProgramData.getProgramTitle());

        TextView tv2 = (TextView)findViewById(R.id.program_code);
        tv2.setText(selectedProgramData.getProgramCode());

        TextView tv3 = (TextView)findViewById(R.id.program_description);
        tv3.setText(selectedProgramData.getProgramDescription());

        // code below is for testing
//        TextView tv1 = (TextView)findViewById(R.id.program_title);
//        tv1.setText("HI");
//
//        TextView tv2 = (TextView)findViewById(R.id.program_code);
//        tv2.setText("MY NAME IS DEV");
//
//        TextView tv3 = (TextView)findViewById(R.id.program_description);
//        tv3.setText("I LOVE CHEESE!");
    }
}