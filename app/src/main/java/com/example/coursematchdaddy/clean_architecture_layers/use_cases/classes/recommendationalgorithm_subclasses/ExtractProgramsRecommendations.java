package com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.recommendationalgorithm_subclasses;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Program;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.RecommendationAlgorithm;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.recommendationalgorithm_class_imports_implementations.ExtractProgramsRecommendationsInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExtractProgramsRecommendations extends RecommendationAlgorithm
        implements ExtractProgramsRecommendationsInterface {
    final static int PROGRAM_LIMIT = 10;
    private final List<Program> programList;
    public ExtractProgramsRecommendations(User user, List<Course> courseList, List<Program> programList) {
        super(user, courseList);
        this.programList = programList;
    }

    @Override
    public List<Program> getProgramRecommendations() {
        List<Program> outputList = new ArrayList<>();
        List<Course> selectedCourses = new ArrayList<>(this.user.getSelectedCourses().values());
        for (Program p : programList) {
            int relevance = calculateRelevance(p, selectedCourses, this.user.getUserSurveyData().getCoursesTaken());
            p.setRelevance(relevance);
            outputList.add(p);
        }
        Collections.sort(outputList);
        int limit = Math.min(PROGRAM_LIMIT, outputList.size());
        return outputList.subList(0, limit);
    }

    /**
     * Calculates the relevance of a program based on selected courses and courses taken.
     *
     * @param program      The program for which relevance needs to be calculated.
     * @param selectedCourses The list of courses selected by the user.
     * @param coursesTaken The list of courses taken by the user.
     * @return The relevance score for the program.
     */
    private int calculateRelevance(Program program, List<Course> selectedCourses, List<String> coursesTaken) {
        int relevance = 0;
        for (Course c : selectedCourses) {
            if (program.getCompletionRequirements().contains(c.getCourseCode())) {
                relevance++;
            }
        }
        for (String courseCode : coursesTaken) {
            if (program.getCompletionRequirements().contains(courseCode)) {
                relevance++;
            }
        }
        return relevance;
    }
}

