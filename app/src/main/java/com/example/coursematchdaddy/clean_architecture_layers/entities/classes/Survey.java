package com.example.coursematchdaddy.clean_architecture_layers.entities.classes;

import java.util.ArrayList;

public abstract class Survey {
    private String program;
    private Float numCredits;
    private ArrayList<String> coursesTaken;
    private ArrayList<String> preferences;

    /**
     * Saves survey data as class attributes and creates instance of Survey
     * @param program
     * @param numCredits
     * @param coursesTaken
     * @param preferences
     */
    public Survey(String program, Float numCredits, ArrayList<String> coursesTaken, ArrayList<String> preferences) {
        this.program = program;
        this.numCredits = numCredits;
        this.coursesTaken = coursesTaken;
        this.preferences = preferences;
    }

    /**
     * return user's program (ex. Math Specialist)
     * @return String
     */
    public String getProgram() {
        return program;
    }

    /**
     * return user's total credits taken (ex. 4.0)
     * @return Float
     */
    public Float getNumCredits() {
        return numCredits;
    }

    /**
     * return list of courses taken
     * @return ArrayList<String>
     */
    public ArrayList<String> getCoursesTaken() {
        return coursesTaken;
    }

    /**
     * return list of preferences
     * @return ArrayList<String>
     */
    public ArrayList<String> getPreferences() {
        return preferences;
    }
}
