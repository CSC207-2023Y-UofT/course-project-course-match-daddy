package com.example.coursematchdaddy.clean_architecture_layers.entities.classes.program_subclasses;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Program;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;

public class Type2Program extends Program {

    /**
     * @param programTitle       : String
     * @param programCode        : String
     * @param programDescription : String
     */
    public Type2Program(String programTitle, String programCode, String programDescription,String completionRequirements) {
        super(programTitle, programCode, programDescription,completionRequirements);
    }

    /**
     * Enroll userData in this program only if they have fulfilled the requirements
     * @param userData: User
     * @param hasRequirements: boolean
     * @return boolean
     */
    public boolean enroll(User userData, boolean hasRequirements) {
        if (hasRequirements) {
            // add program to user's selected programs
            userData.getSelectedPrograms().put(getProgramTitle(), this);
            return true;
        }
        return false;
    }

    /**
     * Unenroll userData
     * @param userData: User
     * @return boolean
     */
    public boolean unenroll(User userData) {
        // Assuming getProgramTitle() returns the program title of the course
        String programTitle = getProgramTitle();

        // Check if the programTitle exists in the user's selected programs
        if (userData.getSelectedPrograms().containsKey(programTitle)) {
            // Remove the programTitle from the user's selected programs and return true (unenroll successful)
            userData.getSelectedPrograms().remove(programTitle);
            return true;
        }

        // If the programTitle was not found in the user's selected programs, return false (unenroll failed)
        return false;
    }


}
