package com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.updatesettings_class_imports_implementations;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;

import java.util.HashMap;

// Provides the method(s) for viewing a user’s settings data.
public interface ViewSettingsDataInterface {
    /**
     * View a user's setting data.
     *
     * @param userData This is an instance of the User class.
     * @return Return a HashMap that contains attributes of an instance of the User class.
     */
    public HashMap<String, Object> getUserData(User userData);
}
