package com.example.coursematchdaddy.clean_architecture_layers.gateways.classes;

import android.annotation.SuppressLint;
import android.util.Log;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Program;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * The GETProgramGateway class is responsible for taking in program data
 * from a CSV file located within the application's storage. The program parses
 * the CSV file and then creates a list of Program objects.
 * The CSV file should be in the following format:
 * ProgramName, ProgramDescription, EnrolmentRequirements, CompletionRequirements, AreaOfStudy
 * An example would be:
 * "Computer Science Specialist", "A specialist program in Computer Science", "None", "None", "Computer Science"
 */
public class GETProgramGateway {
    private final File db;
    private List<Program> programListData;
    private HashMap<String, Program> programListDataMap;
    private final String path = "/data/user/0/com.example.coursematchdaddy/files/programs.csv";

    /**
     * Constructs a GETProgramGateway object.
     * Initializes the File object which represents the CSV file located in the app storage.
     */
    public GETProgramGateway() {
        @SuppressLint("SdCardPath") String path = "/data/user/0/com.example.coursematchdaddy/files/programs.csv";
        db = new File(path);
    }

    /**
     * Retrieves a list of Program objects containing program data from the CSV file.
     *
     * @return A List of Program objects representing programs extracted from the CSV file.
     */

    public List<Program> getProgramsListData() {

        // Initialize the list of Program objects and the HashMap of Program objects
        List<Program> programListData = new ArrayList<>();
        HashMap<String, Program> programListDataMap = new HashMap<>();

        // Initialize the BufferedReader object to read the CSV file
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(this.db));
            // Skip the first line since they are just column names

            br.readLine();
            // Read the rest of the file

            String line;
            while ((line = br.readLine()) != null) {
                List<String> programData = parseCSVLine(line);
                if (programData.size() != 5) {
                    Log.e("GETProgramGateway", "Invalid number of fields in CSV file");
                } else {
                    // Assign the fields to variables
                    String programName = programData.get(0);
                    String programCode = programName.substring(programName.length() - 9);
                    String programDescription = programData.get(1);
                    String completionRequirements = programData.get(3);

                    // Instantiate a Program object and add it to the list of Program objects
                    Program program = new Program(programName, programCode ,programDescription, completionRequirements);
                    programListData.add(program);

//                    Program program = new Program(programName,programName.substring(programName.length() - 9) ,programDescription, completionRequirements);
//                    this.programListData.add(program);
                    // Map the program title to the Program object
                    programListDataMap.put(programName, program);
                }
            }
            // Close the BufferedReader
        } catch(IOException e){
                e.printStackTrace();
            } finally{
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        // Return the list of Program objects
            return programListData;
        }

        /**
         * Parses a line of CSV data and returns a list of fields.
         *
         * @param line The CSV line to parse.
         * @return A List of String containing fields from the CSV line.
         */
        public List<String> parseCSVLine(String line){
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
