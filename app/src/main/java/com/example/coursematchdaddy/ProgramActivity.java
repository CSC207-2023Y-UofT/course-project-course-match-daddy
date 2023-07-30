package com.example.coursematchdaddy;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Program;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.gateways.classes.UserDB;
import com.example.coursematchdaddy.clean_architecture_layers.presenters.classes.ProgramPresenter;

import java.util.ArrayList;
import java.util.HashMap;

public class ProgramActivity extends AppCompatActivity implements RecycleViewInterface{
    private ProgramPresenter presenter;
    private ArrayList<String> programList = new ArrayList<>();
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

        presenter = new ProgramPresenter(new ArrayList<>(currentUser.getSelectedPrograms().values()));


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
        programList.clear();

        for (HashMap<String, String> p : presenter.getProgramData()) {
            Log.e("Program name:", p.get("ProgramTitle"));
            programList.add(p.get("ProgramTitle"));
        }

        rv = findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));
        oa = new OutputAdapter(programList, this);
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
     * @param pos indicates the number of the box that is clicked (increases as you go down)
     */
    @Override
    public void onItemClick(int pos) {

        HashMap<String, String> selectedProgramData = presenter.getProgramData().get(pos);

        TextView tv1 = (TextView)findViewById(R.id.program_title);
        tv1.setText(selectedProgramData.get("ProgramTitle"));

        TextView tv2 = (TextView)findViewById(R.id.program_code);
        tv2.setText(selectedProgramData.get("ProgramCode"));

        TextView tv3 = (TextView)findViewById(R.id.program_description);
        tv3.setText(selectedProgramData.get("ProgramDescription"));

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