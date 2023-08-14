package com.example.coursematchdaddy.clean_architecture_layers.entities.classes.course_subclasses;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.user_subclasses.GuestUser;

import org.junit.Test;

import java.util.HashMap;

public class ClosedEnrollmentCourseTest {
    HashMap<String, Object> miscData;
    ClosedEnrollmentCourse course;

    public void populate() {
        this.miscData = new HashMap<>();

        // populating miscdata and course object
        miscData.put("ProgramArea", "Computer Science");
        miscData.put("Breadth", "The Physical and Mathematical Universes (5)");
        miscData.put("Distribution", "Science");
        miscData.put("RemainingSeats", 40);
        miscData.put("PrerequisitesMet", true);

        this.course = new ClosedEnrollmentCourse("Introduction to Computer Science",
                "CSC148", "An introductory computer science course",
                ".png", miscData);
    }

    @Test
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

    @Test
    public void testEnrollAndUnenroll() {
        populate();

        User temp = new GuestUser();
        course.enroll(temp);

        assertTrue(course.hasPrerequisites(temp));
        assertEquals(temp.getSelectedCourses().get("Introduction to Computer Science"), course);
        assertEquals(course.getRemainingSeats(), 39);

        course.unenroll(temp);

        // testing that seats are being added and removed correctly, and also course is being
        // successfully added to the user
        assertNull(temp.getSelectedCourses().get("Introduction to Computer Science"));
        assertEquals(course.getRemainingSeats(), 40);
    }

    @Test
    public void testEnrollWithNoSeats() {
        populate();

        // enrollment should fail if there are no seats in the course
        course.getMiscellaneousCourseData().put("RemainingSeats", 0);

        User temp = new GuestUser();

        assertFalse(course.enroll(temp));
    }
}
