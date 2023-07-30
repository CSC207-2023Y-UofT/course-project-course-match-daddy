package com.example.coursematchdaddy.clean_architecture_layers.presenters.classes;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Program;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.recommendationalgorithm_class_imports_implementations.ViewProgramDataInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ProgramPresenter implements ViewProgramDataInterface {

    private List<HashMap<String, String>> programDataList = new ArrayList<>();

    /**
     *
     * @param programs
     */
    public ProgramPresenter(List<Program> programs) {
        // Iterate through the list of programs and extract their data
        for (Program program : programs) {
            HashMap<String, String> programData = new HashMap<>();
            programData.put("ProgramTitle", program.getProgramTitle());
            programData.put("ProgramCode", program.getProgramCode());
            programData.put("ProgramDescription", program.getProgramDescription());
            programDataList.add(programData);
        }
    }

    // Provide a method to retrieve the list of program data
    public List<HashMap<String, String>> getProgramData() {
        return programDataList;
    }

    /**
     * return the list of programs to be displayed
     * @return List<Program> list of programs
     */
    public List<HashMap<String, String>> getProgramList() {
        return this.programDataList;
    }

}