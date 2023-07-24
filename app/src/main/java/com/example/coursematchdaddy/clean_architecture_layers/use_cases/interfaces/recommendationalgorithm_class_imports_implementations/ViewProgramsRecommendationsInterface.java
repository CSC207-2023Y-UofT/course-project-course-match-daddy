package com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.recommendationalgorithm_class_imports_implementations;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Program;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;

import java.util.List;

public interface ViewProgramsRecommendationsInterface {
    /**
     * Retrieves a list of recommended programs for the given user based on their data.
     *
     * @param userData The User object representing the user for whom recommendations are generated.
     * @return A List of Program objects representing the recommended programs.
     */
    List<Program> getProgramRecommendations(User userData);
}
