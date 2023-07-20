package com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.recommendationalgorithm_class_imports_implementations;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Program;

public interface ViewProgramDataInterface {
    /**
     * return the program associated with the program code
     * @param programCode
     * @return Program
     */
    public Program getProgramData(String programCode);
}
