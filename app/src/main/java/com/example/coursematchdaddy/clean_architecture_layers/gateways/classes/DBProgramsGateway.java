package com.example.coursematchdaddy.clean_architecture_layers.gateways.classes;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Program;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.swipecarousel_class_imports_implementations.ExtractProgramDataInterface;

public class DBProgramsGateway implements ExtractProgramDataInterface {

    /**
     * return program title from the database
     *
     * @param programData : Program
     * @return String
     */
    @Override
    public String getTitle(Program programData) {
        return programData.getProgramTitle();
    }

    /**
     * return program code from the database
     *
     * @param programData : Program
     * @return String
     */
    @Override
    public String getCode(Program programData) {
        return programData.getProgramCode();
    }

    /**
     * return program description from the database
     *
     * @param programData : Program
     * @return String
     */
    @Override
    public String getDescription(Program programData) {
        return programData.getProgramDescription();
    }


}
