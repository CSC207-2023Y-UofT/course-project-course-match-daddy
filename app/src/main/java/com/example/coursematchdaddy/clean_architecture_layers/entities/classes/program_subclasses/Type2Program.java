package com.example.coursematchdaddy.clean_architecture_layers.entities.classes.program_subclasses;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Program;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;

public class Type2Program extends Program {

    /**
     * Enroll userData in this program only if they have fulfilled the requirements
     * @param userData
     * @param hasRequirements
     * @return
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
     * @param userData
     * @return
     */
    public boolean unenroll(User userData) {
        if (userData.getSelectedPrograms().remove(getProgramTitle())) {
            return true;
        }
        return false;
    }


}
