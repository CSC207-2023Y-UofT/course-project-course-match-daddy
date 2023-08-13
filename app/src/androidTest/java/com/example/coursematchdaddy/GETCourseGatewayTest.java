package com.example.coursematchdaddy;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import java.util.List;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.gateways.classes.GETCourseGateway;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith(AndroidJUnit4.class)
public class GETCourseGatewayTest {

    @Test
    public void testGetCoursesListData() {
        GETCourseGateway courseGateway = new GETCourseGateway();
        List<Course> coursesList = courseGateway.getCoursesListData();
        assertNotNull(coursesList);
        assertTrue(coursesList.size() > 0);
    }

    @Test
    public void testParseCSVLine() {
        GETCourseGateway courseGateway = new GETCourseGateway();
        String line = "\"Introduction to Computer Science\",\"CSC148\",\"An introductory course" +
                " to computer science\",\"Science\",\"The Physical and Mathematical Universes (5)" +
                "\",\"CSC108H1\",\"None\",\"3 hours\"";
        List<String> courseData = courseGateway.parseCSVLine(line);

        assertNotNull(courseData);
        assertEquals(8, courseData.size());
        assertEquals("Introduction to Computer Science", courseData.get(0));
        assertEquals("CSC148", courseData.get(1));
        assertEquals("An introductory course to computer science", courseData.get(2));
        assertEquals("Science", courseData.get(3));
        assertEquals("The Physical and Mathematical Universes (5)", courseData.get(4));
        assertEquals("CSC108H1", courseData.get(5));
        assertEquals("None", courseData.get(6));
        assertEquals("3 hours", courseData.get(7));
    }

    @Test
    public void testImageURL() {
        GETCourseGateway courseGateway = new GETCourseGateway();
        List<Course> coursesList = courseGateway.getCoursesListData();

        // Assert that a course has a given image URL
        assertNotNull(coursesList.get(0).getCourseImageURL());
    }
}
