package com.example.coursematchdaddy.clean_architecture_layers.entities.classes;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public abstract class Survey implements Serializable {
    private String program;
    private Float numCredits;
    private List<String> coursesTaken;
    private HashMap<String, String> completeData;//TODO: outline what this will look like.

    /**
     * Saves survey data as class attributes and creates instance of Survey
     * @param program
     * @param numCredits
     * @param coursesTaken
     * @param completeData
     */
    public Survey(String program, Float numCredits, List<String> coursesTaken, HashMap<String, String> completeData) {
        this.program = program;
        this.numCredits = numCredits;
        this.coursesTaken = coursesTaken;
        this.completeData = completeData;
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
    public List<String> getCoursesTaken() {
        return coursesTaken;
    }

    /**
     * return list of preferences
     * @return ArrayList<String>
     */
    public HashMap<String, String> getCompleteData(){
        return this.completeData;
    }
}
