package com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.swipecarousel_class_imports_implementations;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Program;

public interface ExtractProgramDataInterface {
    
    /**
     * return program title from the database
     * @param programData: Program
     * @return String
     */
    public String getTitle(Program programData);

    /**
     * return program code from the database
     * @param programData: Program
     * @return String
     */
    public String getCode(Program programData);

    /**
     * return program description from the database
     * @param programData: Program
     * @return String
     */
    public String getDescription(Program programData);

    /**
     * return program image url from the database
     * @param programData: Program
     * @return String
     */
    public String getImageURL(Program programData);
}
