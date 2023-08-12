package com.example.coursematchdaddy.clean_architecture_layers.entities.classes.course_subclasses;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.user_subclasses.GuestUser;

import org.junit.Test;

import java.util.HashMap;

public class ArtsAndScienceCourseTest {
    HashMap<String, Object> miscData;
    ArtsAndSciencesCourse course;

    public void populate() {
        this.miscData = new HashMap<>();
        miscData.put("ProgramArea", "Computer Science");
        miscData.put("Breadth", "The Physical and Mathematical Universes (5)");
        miscData.put("Distribution", "Science");
        miscData.put("RemainingSeats", 40);

        this.course = new ArtsAndSciencesCourse("Introduction to Computer Science",
                "CSC148", "An introductory computer science course",
                ".png", miscData);
    }

    @Test
    public void testCreation() {
        populate();
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

    @Test
    public void testEnrollAndUnenroll() {
        populate();

        User temp = new GuestUser();
        course.enroll(temp);

        assertEquals(temp.getSelectedCourses().get("Introduction to Computer Science"), course);
        assertEquals(course.getRemainingSeats(), 39);

        course.unenroll(temp);

        assertNull(temp.getSelectedCourses().get("Introduction to Computer Science"));
        assertEquals(course.getRemainingSeats(), 40);
    }
}