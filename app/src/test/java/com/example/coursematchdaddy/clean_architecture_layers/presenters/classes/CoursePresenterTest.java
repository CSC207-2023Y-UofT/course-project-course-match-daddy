package com.example.coursematchdaddy.clean_architecture_layers.presenters.classes;

import static org.junit.Assert.assertEquals;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.course_subclasses.ArtsAndSciencesCourse;
import com.example.coursematchdaddy.clean_architecture_layers.presenters.classes.CoursePresenter;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CoursePresenterTest {

    @Test
    public void testCoursePresenter() {
        List<Course> courses = generateCourses();
        HashMap<String, Course> courseMap = new HashMap<>();
        for (Course course : courses) {
            courseMap.put(course.getCourseTitle(), course);
        }

        CoursePresenter presenter = new CoursePresenter(courseMap);

        // testing that list is populated correctly

        for (Course course : courses) {
            assertEquals(presenter.getCourseData().get(course.getCourseTitle()), course);
        }

        assertEquals(presenter.getCourseData().get(courses.get(1).getCourseTitle()), courses.get(1));
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
