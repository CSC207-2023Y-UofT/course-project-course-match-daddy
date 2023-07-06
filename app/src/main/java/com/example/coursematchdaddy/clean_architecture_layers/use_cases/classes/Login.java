package com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes;

import com.example.coursematchdaddy.clean_architecture_layers.entities.interfaces.user_class_imports.AdministrationUserInterface;
import com.example.coursematchdaddy.clean_architecture_layers.entities.interfaces.user_class_imports.GuestUserInterface;
import com.example.coursematchdaddy.clean_architecture_layers.entities.interfaces.user_class_imports.LoggedInUserInterface;

public class Login implements LoggedInUserInterface, GuestUserInterface, AdministrationUserInterface {
}
