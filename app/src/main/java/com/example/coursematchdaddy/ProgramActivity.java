package com.example.coursematchdaddy;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Program;
import com.example.coursematchdaddy.clean_architecture_layers.presenters.classes.ProgramPresenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProgramActivity extends AppCompatActivity implements RecycleViewInterface{
    private ProgramPresenter presenter;
    private ArrayList<String> programList = new ArrayList<>();
    RecyclerView rv;
    OutputAdapter oa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program);

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

        for (Program p : getProgramList()) {
            programList.add(getProgramData(p).get(""));
        }

        rv = findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));
        oa = new OutputAdapter(programList, this);
        rv.setAdapter(oa);
    }

    /**
     * Set the presenter of this activity
     * @param pp: the Program Presenter
     */
    public void setPresenter(ProgramPresenter pp) {
        this.presenter = pp;
    }

    /**
     * return the list of programs to be displayed
     * @return List<Program> list of programs
     */
    public List<Program> getProgramList() {
        return presenter.getProgramList();
    }

    /**
     * return the data associated with a selected program
     * @param programCode Program code associated with a program
     * @return Map<String, String> the data that needs to be displayed
     */
    public Map<String, String> getProgramData(String programCode) {
        return presenter.getProgramData(programCode);
    }

    /**
     * return the data associated with a selected program
     * @param program Program object that is selected
     * @return Map<String, String> the data that needs to be displayed
     */
    public Map<String, String> getProgramData(Program program) {
        return presenter.getProgramData(program);
    }

    /**
     * update display information on click
     * @param pos
     */
    @Override
    public void onItemClick(int pos) {
        Log.d("PERSON", Integer.toString(pos));
        HashMap<String, String> selectedProgramData = (HashMap<String, String>)getProgramData(programList.get(pos));

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