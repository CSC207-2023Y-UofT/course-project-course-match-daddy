package com.example.coursematchdaddy.clean_architecture_layers.entities.classes.program_subclasses;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Program;

public class Type1Program extends Program {
    public boolean enroll(User userData) {
        userData.getSelectedPrograms().put(getProgramTitle(), this);
        return true;
    }
    public boolean unenroll(User userData) {
        userData.getSelectedPrograms().remove(getProgramTitle());
        return true;
    }

}
