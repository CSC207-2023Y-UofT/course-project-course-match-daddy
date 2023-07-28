package com.example.coursematchdaddy.clean_architecture_layers.presenters.classes;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Program;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.recommendationalgorithm_class_imports_implementations.ViewProgramDataInterface;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ProgramPresenter implements ViewProgramDataInterface {
    private List<Program> programList;


    /**
     * @param c
     */
    public ProgramPresenter(List<Program> c) {
        this.programList = c;
    }

    /**
     * return the list of programs to be displayed
     * @return List<Program> list of programs
     */
    public List<Program> getProgramList() {
        return this.programList;
    }

    /**
     * return the data associated with a selected program
     * @param programCode Program code associated with a program
     * @return Map<String, String> the data that needs to be displayed
     */
    public Map<String, String> getProgramData(String programCode) {
        // adding all data from the program with the same code as program (String)
        HashMap<String, String> data = new HashMap<String, String>();
        for (Program p : programList) {
            if (Objects.equals(p.getProgramCode(), programCode)) {
                data.put("ProgramCode", p.getProgramCode());
                data.put("ProgramDescription", p.getProgramDescription());
                data.put("ProgramTitle", p.getProgramTitle());
            }
        }
        return data;
    }

    /**
     * return the data associated with a selected program
     * @param program Program object that is selected
     * @return Map<String, String> the data that needs to be displayed
     */
    public Map<String, String> getProgramData(Program program) {
        // adding all data from the program matching with program (Program object)
        HashMap<String, String> data = new HashMap<String, String>();
        for (Program p : programList) {
            if (Objects.equals(p.getProgramCode(), program.getProgramCode())) {
                data.put("ProgramCode", p.getProgramCode());
                data.put("ProgramDescription", p.getProgramDescription());
                data.put("ProgramTitle", p.getProgramTitle());
            }
        }
        return data;
    }

}