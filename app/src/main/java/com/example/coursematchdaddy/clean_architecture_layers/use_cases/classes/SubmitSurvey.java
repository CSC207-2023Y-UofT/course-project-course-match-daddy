package com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes;



import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Survey;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.survey_subclasses.UserData;

import java.util.HashMap;
import java.util.List;

//Acts as a survey factory
public class SubmitSurvey {



    public SubmitSurvey(){

    }

    /**
     * Creates Survey instance
     * @return Survey instance
     */
    public Survey userSubmit(String username, String email, String password,String program,float numCredits, List<String> coursesTaken, HashMap<String, String> completeData) {
        return new UserData(username,email,password,program,numCredits,coursesTaken, completeData);
    }


}
