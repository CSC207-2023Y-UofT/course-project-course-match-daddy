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

    /**
     * Verify that a new user is being created, and write it to the database.
     *
     * @param user user to be written to the database
     * @return true if user was written, false if already exists or an error occurred
     */
    public boolean verifyUser(User user);
}
