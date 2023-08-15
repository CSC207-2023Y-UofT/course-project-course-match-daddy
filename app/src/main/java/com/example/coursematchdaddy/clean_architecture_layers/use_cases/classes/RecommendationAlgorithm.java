package com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Survey;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.recommendationalgorithm_class_imports_implementations.ExtractCoursesRecommendationsInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * This class represents a recommendation algorithm for suggesting courses to users based on their preferences and past courses taken.
 */
//TODO: Decouple this class to promote SRP by shifting some of its responsibilities to its subclasses
public class RecommendationAlgorithm implements ExtractCoursesRecommendationsInterface {

    protected final User user;
    private final List<Course> courseList;
    private static final int COURSE_LIMIT = 100;

    /**
     * Creates a RecommendationAlgorithm object.
     *
     * @param user       The user for whom courses need to be recommended.
     * @param courseList The list of all available courses to choose from.
     */
    public RecommendationAlgorithm(User user, List<Course> courseList) {
        this.user = user;
        this.courseList = courseList;
    }

    /**
     * Get recommended courses for the user.
     *
     * @return A list of recommended courses.
     */
    public List<Course> getCourseRecommendations() {
        List<Course> courses = filterCourses(this.courseList);
        Collections.sort(courses);

        // Extract the top courses or less if the list is smaller
        int limit = Math.min(COURSE_LIMIT, courses.size());
        return courses.subList(0, limit);
    }

    /**
     * Filter courses based on user preferences and past courses taken.
     *
     * @param inputList The list of all available courses to choose from.
     * @return A list of filtered courses based on user preferences.
     */
    private List<Course> filterCourses(List<Course> inputList) {
        List<Course> outputList = new ArrayList<>();
        outputList = removeCoursesTaken(inputList);
        updatePrereqRelevance(outputList);
        updateCreditNumberRelevance(outputList);
        filterByPOSt(outputList);
        updateBreadthRelevance(outputList);
        return outputList;
    }

    /**
     * Remove courses already taken by the user.
     *
     * @param inputList The list of all available courses to choose from.
     * @return A list of courses that the user hasn't taken.
     */
    private List<Course> removeCoursesTaken(List<Course> inputList) {
        List<Course> outputList = new ArrayList<>();

        List<String> courseTaken = this.user.getUserSurveyData().getCoursesTaken();

        for (Course course : inputList) {
            // Check if the course is not already taken by the user
            if (!courseTaken.contains(course.getCourseCode())) {
                outputList.add(course);
            }
        }
        return outputList;
    }

    /**
     * Update relevance of courses based on prerequisites and corequisites.
     *
     * @param inputList The list of courses to update relevance for.
     */
    private void updatePrereqRelevance(List<Course> inputList) {
        List<Course> outPutList = new ArrayList<>();
        List<String> coursesTaken = this.user.getUserSurveyData().getCoursesTaken();

        for (Course c : inputList) {
            String coursePrereqs = (String) c.getMiscellaneousCourseData().get("Prerequisites");
            String courseCoreqs = (String) c.getMiscellaneousCourseData().get("Corequisites");
            for (String s : coursesTaken) {

                // Course in prereq/coreq string => increase relevance
                if (coursePrereqs.contains(s)) {
                    c.setRelevance(c.getRelevance() + 1);
                }
                if (courseCoreqs.contains(s)) {
                    c.setRelevance(c.getRelevance() + 1);
                }
            }
        }
    }

    /**
     * Update relevance of courses based on the credit year difference.
     *
     * @param inputList The list of courses to update relevance for.
     */
    private void updateCreditNumberRelevance(List<Course> inputList) {
        float creditNumber = this.user.getUserSurveyData().getNumCredits();

        for (Course c : inputList) {
            float courseYear = c.getCourseCode().charAt(3) - '0'; // - '0' converts to regular numbers

            // Calculate the difference between the courseYear and the user's credit year
            float yearDifference;
            if (creditNumber < 5) {
                yearDifference = courseYear - 1;
            } else if (creditNumber < 10) {
                yearDifference = courseYear - 2;
            } else if (creditNumber < 15) {
                yearDifference = courseYear - 3;
            } else {
                yearDifference = courseYear - 4;
            }

            // Calculate the relevance based on the year difference
            // Increase relevance for courses closer to the user's credit year
            float relevance = 1 / (1 + Math.abs(yearDifference));

            // Update the relevance value for the course
            c.setRelevance(c.getRelevance() + relevance);
        }
    }

    /**
     * Filter courses based on the user's program area (POSt).
     *
     * @param inputList The list of courses to update relevance for.
     */
    private void filterByPOSt(List<Course> inputList) {
        Survey survey = this.user.getUserSurveyData();
        String programArea = survey.getProgram();

        for (Course c : inputList) {
            // Only use first 3 chars (e.g CSC207 = -> CSC)
            // If the course code is part of the user's program area, increase relevance
            if (programArea.contains(c.getCourseCode().substring(0, 3))) {
                c.setRelevance(c.getRelevance() + 2);
            }
        }
    }

    /**
     * Update relevance of courses based on breadth preferences.
     *
     * @param inputList The list of courses to update relevance for.
     */
    private void updateBreadthRelevance(List<Course> inputList) {
        Survey survey = this.user.getUserSurveyData();
        HashMap<String, String> userPreferences = survey.getCompleteData();
        List<String> possibleKeys = new ArrayList<>();

        for (String key : userPreferences.keySet()) {
            // User checked this box, consider it as a possible breadth requirement
            if (userPreferences.get(key).equals("true")) {
                possibleKeys.add(key);
            }
        }

        for (Course c : inputList) {
            String courseBreadth = c.getBreadth();
            for (String key : possibleKeys) {
                // If the course satisfies any of the user's breadth requirements, increase relevance
                if (courseBreadth.contains(key)) {
                    c.setRelevance(c.getRelevance() + 1);
                }
            }
        }
    }
    /**
     * Retrieves the list of courses
     *
     * @return A List of Course objects representing the courses available.
     */
    public List<Course> getCourseList() {
        return this.courseList;
    }


}
