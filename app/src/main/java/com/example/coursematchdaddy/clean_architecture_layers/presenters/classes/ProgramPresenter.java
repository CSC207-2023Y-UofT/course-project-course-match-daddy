package com.example.coursematchdaddy.clean_architecture_layers.presenters.classes;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Program;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.recommendationalgorithm_class_imports_implementations.ViewProgramDataInterface;

import java.util.HashMap;

public class ProgramPresenter implements ViewProgramDataInterface {

    private final HashMap<String, Program> programDataList;

    /**
     *
     * @param programDataList hashmap containing program titles as strings and programs as values
     */
    public ProgramPresenter(HashMap<String, Program> programDataList) {
        this.programDataList = programDataList;
    }

    /**
     * return the list of programs to be displayed
     * @return List<Program> list of programs
     */
    public HashMap<String, Program> getProgramData() {
        return programDataList;
    }

}