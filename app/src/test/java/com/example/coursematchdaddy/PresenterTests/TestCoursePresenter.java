package com.example.coursematchdaddy.PresenterTests;

import static org.junit.Assert.assertEquals;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.course_subclasses.ArtsAndSciencesCourse;
import com.example.coursematchdaddy.clean_architecture_layers.presenters.classes.CoursePresenter;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestCoursePresenter {

    @Test
    public void testCoursePresenter() {
        List<Course> courses = generateCourses();

        CoursePresenter presenter = new CoursePresenter(courses);

        // testing that list is populated correctly
        assertEquals(presenter.getCourseData().get(1).get("CourseTitle"), courses.get(1).getCourseTitle());
        assertEquals(presenter.getCourseData().get(1).get("CourseCode"), courses.get(1).getCourseCode());
        assertEquals(presenter.getCourseData().get(1).get("CourseDescription"), courses.get(1).getCourseDescription());
    }

    public List<Course> generateCourses() {
        List<Course> courses = new ArrayList<>();

        HashMap<String, Object> miscData;

        miscData = new HashMap<>();
        miscData.put("ProgramArea", "Computer Science");
        miscData.put("Breadth", "The Physical and Mathematical Universes (5)");
        miscData.put("Distribution", "Science");
        miscData.put("RemainingSeats", 40);

        courses.add(new ArtsAndSciencesCourse("Introduction to Computer Science",
                "CSC148", "An introductory computer science course",
                ".png", miscData));

        miscData = new HashMap<>();
        miscData.put("ProgramArea", "Mathematics");
        miscData.put("Breadth", "The Physical and Mathematical Universes (5)");
        miscData.put("Distribution", "Science");
        miscData.put("RemainingSeats", 30);

        courses.add(new ArtsAndSciencesCourse("Introduction to Mathematical Proofs",
                "MAT102", "Introduction to mathematical ideas",
                ".png", miscData));


        return courses;
    }

}
