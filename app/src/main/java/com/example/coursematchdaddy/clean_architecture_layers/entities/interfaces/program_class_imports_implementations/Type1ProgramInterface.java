package com.example.coursematchdaddy.clean_architecture_layers.entities.interfaces.program_class_imports_implementations;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;

public interface Type1ProgramInterface {

    /**
     * Add this user to their selected programs
     * @param userData: User
     * @return boolean
     */
    public boolean enroll(User userData);

    /**
     * Remove this user from their selected programs
     * @param userData: User
     * @return boolean
     */
    public boolean unenroll(User userData);
}
