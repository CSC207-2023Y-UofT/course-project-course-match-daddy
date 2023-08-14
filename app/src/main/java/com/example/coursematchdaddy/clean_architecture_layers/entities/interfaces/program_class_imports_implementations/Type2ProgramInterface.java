package com.example.coursematchdaddy.clean_architecture_layers.entities.interfaces.program_class_imports_implementations;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;

public interface Type2ProgramInterface {

    /**
     * Enroll userData in this program only if they have fulfilled the requirements
     * @param userData: User
     * @param hasRequirements: boolean
     * @return boolean
     */
    boolean enroll(User userData, boolean hasRequirements);

    /**
     * Unenroll userData
     * @param userData: User
     * @return boolean
     */
    boolean unenroll(User userData);
}
