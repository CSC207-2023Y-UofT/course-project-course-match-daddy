
package com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.recommendationalgorithm_class_imports_implementations;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Program;

import java.util.List;

public interface ExtractProgramsRecommendationsInterface {

    /**
     * Retrieves a list of recommended programs for a given user based on the provided user data.
     *
     * @return A List of recommended Program objects.
     */
    List<Program> getProgramRecommendations();
}