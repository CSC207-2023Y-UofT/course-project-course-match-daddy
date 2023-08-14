package com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.updatesettings_class_imports_implementations;

// Provides the method(s) to update a user’s data.
public interface UpdateSettingsDataInterface {
    /**
     * Update a user's data.
     *
     * @param email This is a unique identifier of a user.
     * @return Return true if a user's data was successfully updated.
     */
    boolean updateUserData(String email);
}
