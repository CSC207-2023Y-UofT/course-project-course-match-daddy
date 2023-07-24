
package com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.recommendationalgorithm_class_imports_implementations;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Program;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;

import java.util.List;

public interface ExtractProgramsRecommendationsInterface {

    /**
     * Retrieves a list of recommended programs for a given user based on the provided user data.
     *
     * @param userData The User object containing the relevant data for generating program recommendations.
     * @return A List of recommended Program objects.
     */
    List<Program> getProgramRecommendations(User userData);
}
