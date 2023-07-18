package com.example.coursematchdaddy.clean_architecture_layers.presenters.classes;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Program;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.recommendationalgorithm_class_imports_implementations.ViewProgramsRecommendationsInterface;

import java.util.HashMap;
import java.util.List;

public class ProgramRecommendationsPresenter implements ViewProgramsRecommendationsInterface {
    @Override
    public List<Program> getProgramRecommendations(User userData) {
        // <getSelectedPrograms> is a dictionary that maps program names
        // to program objects. Im returning all program objects in this dictionary
        return ((HashMap)userData.getSelectedPrograms()).values();
    }
}
