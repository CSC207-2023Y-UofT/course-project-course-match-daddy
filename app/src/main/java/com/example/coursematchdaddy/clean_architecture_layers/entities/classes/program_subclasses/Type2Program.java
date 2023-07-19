package com.example.coursematchdaddy.clean_architecture_layers.entities.classes.program_subclasses;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Program;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;

public class Type2Program extends Program {

    public boolean enroll(User userData, boolean hasRequirements) {
        if (hasRequirements) {
            userData.getSelectedPrograms().put(getProgramTitle(), this);
            return true;
        }
        return false;
    }
    public boolean unenroll(User userData) {
        if (userData.getSelectedPrograms().remove(getProgramTitle())) {
            return true;
        }
        return false;
    }


}
