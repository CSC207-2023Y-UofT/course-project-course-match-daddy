package com.example.coursematchdaddy.clean_architecture_layers.entities.interfaces.program_class_imports_implementations;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;

public interface Type3ProgramInterface {

    /**
     * return whether this program has space to be enrolled in
     * @return boolean
     */
    public boolean hasSpace();

    /**
     * Enroll userData into the program if there are seats remaining, and requirements are
     * fulfilled
     * @param userData: User
     * @param hasRequirements: boolean
     * @return boolean
     */
    public boolean enroll(User userData, boolean hasRequirements);

    /**
     * Unenroll userData from program
     * @param userData: User
     * @return boolean: boolean
     */
    public boolean unenroll(User userData);

}
