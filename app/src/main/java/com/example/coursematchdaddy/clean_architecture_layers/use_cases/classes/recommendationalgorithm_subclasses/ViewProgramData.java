package com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.recommendationalgorithm_subclasses;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Program;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Survey;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.RecommendationAlgorithm;

import java.util.List;

public class ViewProgramData extends RecommendationAlgorithm {
    private User user;

    /**
     * Creates a RecommendationAlgorithm object.
     *
     * @param user       The user for whom courses need to be recommended.
     * @param courseList The list of all available courses to choose from.
     */
    public ViewProgramData(User user, List<Course> courseList) {
        super(user, courseList);
    }

    /**
     * returning a program based on its code
     * @param programCode program code
     * @return Program: the program associated with the provided code
     */
    public Program getProgramData(String programCode) {
        
        if (this.user.getSelectedPrograms().containsKey(programCode)) {
            return this.user.getSelectedPrograms().get(programCode);
        }
        return null;
    }

}
