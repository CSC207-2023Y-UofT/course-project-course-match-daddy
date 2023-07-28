package com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes;



import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.survey_subclasses.GenericData;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.survey_subclasses.UserData;
import com.example.coursematchdaddy.clean_architecture_layers.gateways.classes.DBUsersGateway;

import java.util.ArrayList;


public class SubmitSurvey {

    private String program;
    private Float numCredits;
    private ArrayList<String> courses;
    private ArrayList<String> preferences;

    /**
     * Creates SubmitSurvey isntance
     * @param program
     * @param numCredits
     * @param courses
     * @param preferences
     */
    public SubmitSurvey(String program, Float numCredits, ArrayList<String> courses, ArrayList<String> preferences){
        this.program = program;
        this.numCredits = numCredits;
        this.courses = courses;
        this.preferences = preferences;

    }

    /**
     * Creates Survey instance and verifies save to db
     * @param username
     * @param email
     * @param password
     * @param db
     * @return Boolean
     */
    public Boolean userSubmit(String username, String email, String password, DBUsersGateway db) {
        UserData data = new UserData(username, email, password, program, numCredits, courses, preferences);

        //Assumes SaveSurveyDataInterface will have saveSurvey() and it will return a boolean
        return db.saveSurvey(data);
    }

    /**
     * Creates generic user survey and verifies save to db
     * @param db
     * @return
     */
    public Boolean genericSubmit(DBUsersGateway db){
        GenericData data = new GenericData(program, numCredits, courses, preferences);

        //Assumes SaveSurveyDataInterface will have saveSurvey() and it will return a boolean
        return db.saveSurvey(data);
    }


}
