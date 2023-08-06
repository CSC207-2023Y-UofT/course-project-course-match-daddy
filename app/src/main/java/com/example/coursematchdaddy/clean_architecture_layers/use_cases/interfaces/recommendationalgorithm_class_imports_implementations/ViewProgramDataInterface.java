package com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.recommendationalgorithm_class_imports_implementations;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Program;

import java.util.HashMap;

public interface ViewProgramDataInterface {
    /**
     * return the data associated with a selected program
     *
     * @return Map<String, String> the data that needs to be displayed
     */
    public HashMap<String, Program> getProgramData();

}
