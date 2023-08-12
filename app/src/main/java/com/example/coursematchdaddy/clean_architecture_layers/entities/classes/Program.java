package com.example.coursematchdaddy.clean_architecture_layers.entities.classes;

import java.io.Serializable;

public class Program implements Serializable, Comparable<Program> {
    private final String programTitle;
    private final String programCode;
    private final String programDescription;
    private double relevance;
    private final String completionRequirements;

    /**
     * @param programTitle: String
     * @param programCode: String
     * @param programDescription: String
     */
    public Program(String programTitle, String programCode, String programDescription, String completionRequirements) {
        this.programTitle = programTitle;
        this.programCode = programCode;
        this.programDescription = programDescription;
        this.relevance = 0;
        this.completionRequirements = completionRequirements;
    }

    /**
     * return program title (ex. Computer Science Specialist)
     * @return String
     */
    public String getProgramTitle() {
        return this.programTitle;
    }

    /**
     * return program code (ex. ERSPE1688)
     * @return String
     */
    public String getProgramCode() {
        return this.programCode;
    }
    @Override
    public int compareTo(Program other) {
        // Compare by relevance in descending order
        return Double.compare(other.getRelevance(), this.relevance);
    }

    public double getRelevance() {
        return this.relevance;
    }
    public void setRelevance(double d){
        this.relevance = d;
    }

    /**
     * return program description (ex. This program provides...)
     * @return String
     */
    public String getProgramDescription() {
        return this.programDescription;
    }
    public String getCompletionRequirements(){
        return this.completionRequirements;
    }

}
