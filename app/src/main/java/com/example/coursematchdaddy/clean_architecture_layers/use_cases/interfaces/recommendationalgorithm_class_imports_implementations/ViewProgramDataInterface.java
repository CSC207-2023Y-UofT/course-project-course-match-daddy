package com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.recommendationalgorithm_class_imports_implementations;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Program;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public interface ViewProgramDataInterface {
    /**
     * return the program associated with the program code
     * @param programCode: String
     * @return Program
     */
    public Map<String, String> getProgramData(String programCode);

    /**
     * return the data associated with a selected program
     * @param program Program object that is selected
     * @return Map<String, String> the data that needs to be displayed
     */
    public Map<String, String> getProgramData(Program program);

}
