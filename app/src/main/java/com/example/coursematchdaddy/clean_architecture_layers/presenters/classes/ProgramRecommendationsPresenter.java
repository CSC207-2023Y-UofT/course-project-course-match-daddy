package com.example.coursematchdaddy.clean_architecture_layers.presenters.classes;

import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.recommendationalgorithm_class_imports_implementations.ViewProgramsRecommendationsInterface;

public class ProgramRecommendationsPresenter implements ViewProgramsRecommendationsInterface {
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


public class ProgramRecommendationsPresenter implements ViewProgramsRecommendationsInterface {
    private List<Program> programList;

    public ProgramRecommendationsPresenter(List<Program> p) {
        this.programList = p;

    }

    /**
     * Retrieves a list of program recommendations for the specified user.
     *
     * @param userData The User.
     * @return A list of Program objects representing the recommended programs for the user.
     */
    @Override
    public List<Program> getProgramRecommendations(User userData) {
        // The <getSelectedPrograms> method returns a dictionary that maps program names to program objects.
        // Here, we are returning all program objects in this dictionary as the recommendations.
        return (List<Program>)userData.getSelectedPrograms().values();
    }

    /**
     * return the data associated with a selected program
     *
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