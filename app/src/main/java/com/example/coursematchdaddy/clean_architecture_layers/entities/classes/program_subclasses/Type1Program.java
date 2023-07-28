package com.example.coursematchdaddy.clean_architecture_layers.entities.classes.program_subclasses;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Program;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;

public class Type1Program extends Program {

    /**
     * @param programTitle       : String
     * @param programCode        : String
     * @param programDescription : String
     */
    public Type1Program(String programTitle, String programCode, String programDescription) {
        super(programTitle, programCode, programDescription);
    }

    /**
     * Add this user to their selected programs
     * @param userData: User
     * @return boolean
     */
    public boolean enroll(User userData) {
        userData.getSelectedPrograms().put(getProgramTitle(), this);
        return true;
    }

    /**
     * Remove this user from their selected programs
     * @param userData: User
     * @return boolean
     */
    public boolean unenroll(User userData) {
        // Assuming getProgramTitle() returns the program title of the course
        String programTitle = getProgramTitle();

        // Check if the programTitle exists in the user's selected programs
        if (userData.getSelectedPrograms().containsKey(programTitle)) {
            // Remove the programTitle from the user's selected programs
            userData.getSelectedPrograms().remove(programTitle);
            return true; // Unenroll successful
        }

        return false; // Unenroll failed
    }

}
