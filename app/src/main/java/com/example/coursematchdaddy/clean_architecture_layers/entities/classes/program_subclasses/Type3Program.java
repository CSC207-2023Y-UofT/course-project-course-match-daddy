package com.example.coursematchdaddy.clean_architecture_layers.entities.classes.program_subclasses;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Program;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;

public class Type3Program extends Program {

    /**
     * return whether this program has space to be enrolled in
     * @return boolean
     */
    public boolean hasSpace() {
        return true;
    }

    /**
     * Enroll userData into the program if there are seats remaining, and requirements are
     * fulfilled
     * @param userData: User
     * @param hasRequirements: boolean
     * @return boolean
     */
    public boolean enroll(User userData, boolean hasRequirements) {
        // check program reqs fulfilled and seats available
        if (hasRequirements && hasSpace()) {
            // add program to user's selected programs
            userData.getSelectedPrograms().put(getProgramTitle(), this);
            return true;
        }
        return false;
    }

    /**
     * Unenroll userData from program
     * @param userData: User
     * @return boolean: boolean
     */
    public boolean unenroll(User userData) {
        // remove program from user's selections
        if (userData.getSelectedPrograms().remove(getProgramTitle())) {
            return true;
        }
        return false;
    }
}
