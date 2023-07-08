package com.example.coursematchdaddy.clean_architecture_layers.entities.interfaces.user_class_imports_implementations;

import java.util.HashMap;

public interface LoggedInUserInterface {
    HashMap<String, Object> getLoginCredentials();
    HashMap<String, Object> getUserData();

}
