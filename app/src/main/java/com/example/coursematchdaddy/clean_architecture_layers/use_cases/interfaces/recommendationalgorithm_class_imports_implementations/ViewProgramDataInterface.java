package com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.recommendationalgorithm_class_imports_implementations;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Program;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface ViewProgramDataInterface {
//    /**
//     * return the program associated with the program code
//     * @param programCode: String
//     * @return Program
//     */
//    public Map<String, String> getProgramData(String programCode);

    /**
     * return the data associated with a selected program
     *
     * @return Map<String, String> the data that needs to be displayed
     */
    public List<HashMap<String, String>> getProgramData();

}
