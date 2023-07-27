package com.example.coursematchdaddy.clean_architecture_layers.presenters.classes;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.updatesettings_class_imports_implementations.ViewSettingsDataInterface;

import java.util.HashMap;

public class SettingsPresenter implements ViewSettingsDataInterface {
    /**
     * View a user's setting data.
     *
     * @param userData This is an instance of the User class.
     * @return Return a HashMap that contains attributes of an instance of the User class.
     */
    @Override
    public HashMap<String, Object> getUserData(User userData) {
        return null;
    }
}
