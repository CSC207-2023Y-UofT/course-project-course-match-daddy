package com.example.coursematchdaddy.clean_architecture_layers.entities.classes;

import java.util.ArrayList;

public abstract class Survey {
    private String program;
    private Integer numCredits;
    private ArrayList<String> courses;
    private ArrayList<String> preferences;

    public Survey(String program, Integer numCredits, ArrayList<String> courses, ArrayList<String> preferences) {
        this.program = program;
        this.numCredits = numCredits;
        this.courses = courses;
        this.preferences = preferences;
    }

    public String getProgram() {
        return program;
    }

    public Integer getNumCredits() {
        return numCredits;
    }

    public ArrayList<String> getCourses() {
        return courses;
    }

    public ArrayList<String> getPreferences() {
        return preferences;
    }
}
