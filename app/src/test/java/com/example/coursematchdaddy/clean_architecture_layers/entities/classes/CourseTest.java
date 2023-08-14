package com.example.coursematchdaddy.clean_architecture_layers.entities.classes;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.course_subclasses.ArtsAndSciencesCourse;

import junit.framework.TestCase;

import java.util.HashMap;

public class CourseTest extends TestCase {
    HashMap<String, Object> miscData;
    ArtsAndSciencesCourse course;

    public void populate() {

        // populating miscdata and course object
        this.miscData = new HashMap<>();
        miscData.put("ProgramArea", "Computer Science");
        miscData.put("Breadth", "The Physical and Mathematical Universes (5)");
        miscData.put("Distribution", "Science");
        miscData.put("RemainingSeats", 40);

        this.course = new ArtsAndSciencesCourse("Introduction to Computer Science",
                "CSC148", "An introductory computer science course",
                ".png", miscData);
    }

    public void testCreation() {
        populate();

        // testing basic course info, and also miscdata hashmap
        assertEquals(course.getCourseTitle(), "Introduction to Computer Science");
        assertEquals(course.getCourseCode(), "CSC148");
        assertEquals(course.getCourseDescription(), "An introductory computer science course");
        assertEquals(course.getCourseImageURL(), ".png");
        assertEquals(course.getMiscellaneousCourseData(), miscData);

        assertEquals(course.getProgramArea(), "Computer Science");
        assertEquals(course.getBreadth(), "The Physical and Mathematical Universes (5)");
        assertEquals(course.getDistribution(), "Science");
        assertEquals(course.getRemainingSeats(), 40);
    }
}