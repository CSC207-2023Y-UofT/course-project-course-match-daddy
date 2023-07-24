package com.example.coursematchdaddy.clean_architecture_layers.entities.interfaces.user_class_imports_implementations;

import java.util.HashMap;

// Provides the method(s) for manipulating a guest user’s data.
public interface GuestUserInterface {
    /**
     * Retrieve a guest user's data.
     *
     * @return Retrieve a guest user's data.
     */
    public HashMap<String, Object> getUserData();
}
