package com.example.coursematchdaddy.clean_architecture_layers.gateways.classes;

import android.util.Log;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.course_subclasses.ArtsAndSciencesCourse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * The GETCourseGateway class represents a gateway responsible for retrieving course data
 * from a CSV file in the app's internal storage. It parses the CSV file containing course
 * information and provides a list of Course objects.
 *
 * The CSV file should be in the following format:
 * CourseName,CourseCode,CourseDescription,DistributionRequirements,
 * BreadthRequirements,Prerequisites,Corequisites,Hours
 *
 * Example:
 * "Introduction to Computer Science","CS101","An introductory course to programming",
 * "Mathematics","Natural Sciences","None","None","3 hours"
 *
 * The course data is extracted from the CSV file, and a list of Course objects is created
 * containing ArtsAndSciencesCourse objects. The course data is also stored in a HashMap
 * for easy retrieval.
 *
 * This class assumes that the CSV file is located at the specified path in the app's internal storage.
 */
public class GETCourseGateway {
    private List<Course> coursesListData;
    private HashMap<String, Course> coursesListDataMap;
    private File db;
    private final String path = "/data/user/0/com.example.coursematchdaddy/files/data/user/0/com.example.coursematchdaddy/files/artssci.csv";

    /**
     * Constructs a GETCourseGateway object.
     * Initializes the File object representing the CSV file in the app's internal storage.
     */
    public GETCourseGateway() {
        db = new File(path);
    }

    /**
     * Retrieves a list of Course objects containing course data from the CSV file.
     *
     * @return A List of Course objects representing courses extracted from the CSV file.
     */
    public List<Course> getCoursesListData() {
        this.coursesListData = new ArrayList<>();
        this.coursesListDataMap = new HashMap<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(this.db));
            // Skip the first line (header) as it contains column names
            br.readLine();

            String line;
            while ((line = br.readLine()) != null) {
                List<String> courseData = parseCSVLine(line);
                if (courseData.size() == 8) {
                    String courseName = courseData.get(0);
                    String courseCode = courseData.get(1);
                    String courseDescription = courseData.get(2);
                    String distributionRequirements = courseData.get(3);
                    String breadthRequirements = courseData.get(4);
                    String prerequisites = courseData.get(5);
                    String corequisites = courseData.get(6);
                    String hours = courseData.get(7);

                    // Create a HashMap for the miscellaneous course data
                    HashMap<String, Object> miscellaneousCourseData = new HashMap<>();
                    miscellaneousCourseData.put("Distribution", distributionRequirements);
                    miscellaneousCourseData.put("Breadth", breadthRequirements);
                    miscellaneousCourseData.put("Prerequisites", prerequisites);
                    miscellaneousCourseData.put("Hours", hours);
                    miscellaneousCourseData.put("Corequisites", corequisites);
                    // Add other relevant data as needed

                    // Create a new Course object with the extracted data
                    Course course = new ArtsAndSciencesCourse(courseName, courseCode, courseDescription,
                            /* courseImageURL: */ "TEMPURL", miscellaneousCourseData);
                    this.coursesListData.add(course);
                    this.coursesListDataMap.put(courseCode, course);
                } else {
                    Log.e("LOG", "INVALID INPUT");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return this.coursesListData;
    }

    /**
     * Parses a line of CSV data and returns a list of fields.
     *
     * @param line The CSV line to parse.
     * @return A List of String containing fields from the CSV line.
     */
    private List<String> parseCSVLine(String line) {
        List<String> fields = new ArrayList<>();
        StringBuilder currentField = new StringBuilder();
        boolean withinQuotes = false;

        for (char c : line.toCharArray()) {
            if (c == ',' && !withinQuotes) {
                fields.add(currentField.toString());
                currentField.setLength(0);
            } else if (c == '"' && !withinQuotes) {
                withinQuotes = true;
            } else if (c == '"' && withinQuotes) {
                withinQuotes = false;
            } else {
                currentField.append(c);
            }
        }
        fields.add(currentField.toString());
        return fields;
    }
}
