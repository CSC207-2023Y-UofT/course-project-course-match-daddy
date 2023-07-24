package com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.swipecarousel_subclasses;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Program;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.SwipeCarousel;

public class ExtractProgramData extends SwipeCarousel {
    /**
     * return program title from the database
     * @param programData: Program
     * @return String
     */
    public String getTitle(Program programData) {
        return programData.getProgramTitle();
    }

    /**
     * return program code from the database
     * @param programData: Program
     * @return String
     */
    public String getCode(Program programData) {
        return programData.getProgramCode();
    }

    /**
     * return program description from the database
     * @param programData: Program
     * @return String
     */
    public String getDescription(Program programData) {
        return programData.getProgramDescription();
    }

}
