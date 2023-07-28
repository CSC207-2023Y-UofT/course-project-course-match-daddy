package com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.login_class_imports_implementations;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;

public interface CreateUserAccountInterface {
    /**
     * Add or update a user within the text file.
     *
     * @param userData This is the provided user's data.
     * @return Return true if this operation is successful.
     */
    public boolean updateUserData(User userData);
}
