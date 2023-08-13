package com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes;

import static org.junit.Assert.assertEquals;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.course_subclasses.ArtsAndSciencesCourse;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.user_subclasses.GuestUser;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestRecommendationAlgorithm {

    @Test
    public void testRemoveCoursesTaken() {
        User temp = new GuestUser();
        HashMap<String, Course> courseList = new HashMap<>();
        List<Course> courses = generateCourses();
//        courseList.put(courses.get(0).getCourseTitle(), courses.get(0));

        temp.getUserSurveyData().getCoursesTaken().add("CSC108");

        RecommendationAlgorithm algorithm = new RecommendationAlgorithm(temp, courses);

        // testing that removeCoursesTaken works correctly
        assertEquals(8, algorithm.getCourseRecommendations().size());

    }

    @Test
    public void testRecommendationRelevance() {
        // instantiating
        User temp = new GuestUser();


        List<Course> courses = generateCourses();

        // adding course
        temp.getUserSurveyData().getCoursesTaken().add("CSC108");

        // assigning algorithm
        RecommendationAlgorithm algorithm = new RecommendationAlgorithm(temp, courses);

        assertEquals(algorithm.getCourseList(), courses);

        algorithm.getCourseRecommendations();

        // CSC148 -> Corequisite (1.0) + Breadth (1.0)
        assertEquals(2, (int)courses.get(0).getRelevance());

        // MAT102 -> Same year (1.0)
        assertEquals(1, (int)courses.get(1).getRelevance());

        // CSC207 -> 1 Year up (0.5)
        assertEquals(0.5, (float)courses.get(5).getRelevance(), 0.005);
    }

    public List<Course> generateCourses() {
        List<Course> courses = new ArrayList<>();

        HashMap<String, Object> miscData;

        // 1
        miscData = new HashMap<>();
        miscData.put("ProgramArea", "Computer Science");
        miscData.put("Breadth", "The Physical and Mathematical Universes (5)");
        miscData.put("Distribution", "Science");
        miscData.put("Prerequisites", "");
        miscData.put("Corequisites", "CSC108");
        miscData.put("RemainingSeats", 40);

        courses.add(new ArtsAndSciencesCourse("Introduction to Computer Science",
                "CSC148", "An introductory computer science course",
                ".png", miscData));

        // 2
        miscData = new HashMap<>();
        miscData.put("ProgramArea", "Mathematics");
        miscData.put("Breadth", "The Physical and Mathematical Universes (5)");
        miscData.put("Distribution", "Science");
        miscData.put("Prerequisites", "");
        miscData.put("Corequisites", "");
        miscData.put("RemainingSeats", 30);

        courses.add(new ArtsAndSciencesCourse("Introduction to Mathematical Proofs",
                "MAT102", "Introduction to mathematical ideas",
                ".png", miscData));

        // 3
        miscData = new HashMap<>();
        miscData.put("ProgramArea", "Mathematics");
        miscData.put("Breadth", "The Physical and Mathematical Universes (5)");
        miscData.put("Distribution", "Science");
        miscData.put("Prerequisites", "");
        miscData.put("Corequisites", "MAT136");
        miscData.put("RemainingSeats", 50);

        courses.add(new ArtsAndSciencesCourse("Differential Calculus",
                "MAT135", "Differentiation techniques",
                ".png", miscData));

        // 4
        miscData = new HashMap<>();
        miscData.put("ProgramArea", "Computer Science");
        miscData.put("Breadth", "The Physical and Mathematical Universes (5)");
        miscData.put("Distribution", "Science");
        miscData.put("Prerequisites", "");
        miscData.put("Corequisites", "");
        miscData.put("RemainingSeats", 42);

        courses.add(new ArtsAndSciencesCourse("Introduction to Computer Programming",
                "CSC108", "Basic coding with Python",
                ".png", miscData));

        // 5
        miscData = new HashMap<>();
        miscData.put("ProgramArea", "Mathematics");
        miscData.put("Breadth", "The Physical and Mathematical Universes (5)");
        miscData.put("Distribution", "Science");
        miscData.put("Prerequisites", "");
        miscData.put("Corequisites", "");
        miscData.put("RemainingSeats", 23);

        courses.add(new ArtsAndSciencesCourse("Integral Calculus",
                "MAT136", "Learning techniques in integral calculus",
                ".png", miscData));

        // 6
        miscData = new HashMap<>();
        miscData.put("ProgramArea", "Computer Science");
        miscData.put("Breadth", "The Physical and Mathematical Universes (5)");
        miscData.put("Distribution", "Science");
        miscData.put("Prerequisites", "CSC148");
        miscData.put("Corequisites", "");
        miscData.put("RemainingSeats", 10);

        courses.add(new ArtsAndSciencesCourse("Software Design",
                "CSC207", "Learning how to code and design",
                ".png", miscData));

        // 7
        miscData = new HashMap<>();
        miscData.put("ProgramArea", "Computer Science");
        miscData.put("Breadth", "The Physical and Mathematical Universes (5)");
        miscData.put("Distribution", "Science");
        miscData.put("Prerequisites", "CSC207 CSC148");
        miscData.put("Corequisites", "");
        miscData.put("RemainingSeats", 70);

        courses.add(new ArtsAndSciencesCourse("Software Tools and Systems Programming",
                "CSC209", "Software development in a low level",
                ".png", miscData));

        // 8
        miscData = new HashMap<>();
        miscData.put("ProgramArea", "Mathematics");
        miscData.put("Breadth", "The Physical and Mathematical Universes (5)");
        miscData.put("Distribution", "Science");
        miscData.put("Prerequisites", "");
        miscData.put("Corequisites", "");
        miscData.put("RemainingSeats", 100);

        courses.add(new ArtsAndSciencesCourse("Analysis |",
                "MAT157", "Real Analysis.",
                ".png", miscData));

        // 9
        miscData = new HashMap<>();
        miscData.put("ProgramArea", "Computer Science");
        miscData.put("Breadth", "The Physical and Mathematical Universes (5)");
        miscData.put("Distribution", "Science");
        miscData.put("Prerequisites", "CSC108");
        miscData.put("Corequisites", "");
        miscData.put("RemainingSeats", 50);

        courses.add(new ArtsAndSciencesCourse("Mathematical Expression and Reasoning for Computer Science",
                "CSC165", "CSC148 but harder",
                ".png", miscData));

        return courses;
    }
}
