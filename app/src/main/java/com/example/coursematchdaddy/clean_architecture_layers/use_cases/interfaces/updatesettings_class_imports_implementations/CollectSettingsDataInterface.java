package com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.updatesettings_class_imports_implementations;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;

// Provides the method(s) that collects a user’s provided settings data.
public interface CollectSettingsDataInterface {
    /**
     * Retrieve a user's provided data from the settings view.
     *
     * @return Return true if the data was successfully collected.
     */
    public boolean collectSettingsData();
}
