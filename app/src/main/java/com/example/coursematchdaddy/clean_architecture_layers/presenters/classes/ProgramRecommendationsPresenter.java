package com.example.coursematchdaddy.clean_architecture_layers.presenters.classes;

import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.recommendationalgorithm_class_imports_implementations.ViewProgramsRecommendationsInterface;

public class ProgramRecommendationsPresenter implements ViewProgramsRecommendationsInterface {
import java.util.HashMap;
import java.util.List;


public class ProgramRecommendationsPresenter implements ViewProgramsRecommendationsInterface {

    /**
     * Retrieves a list of program recommendations for the specified user.
     *
     * @param userData The User.
     * @return A list of Program objects representing the recommended programs for the user.
     */
    @Override
    public List<Program> getProgramRecommendations(User userData) {
        // The <getSelectedPrograms> method returns a dictionary that maps program names to program objects.
        // Here, we are returning all program objects in this dictionary as the recommendations.
        return ((HashMap<String, Program>) userData.getSelectedPrograms()).values();
    }
}
