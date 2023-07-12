package com.example.coursematchdaddy.clean_architecture_layers.entities.interfaces.survey_class_imports_implementations;

import java.util.ArrayList;

public interface UserDataInterface {
    public void setProgram(String program);

    public void setCredits(int num);

    public void setCourses(ArrayList<String> courses);

    public void setPreferences(ArrayList<String> preferences);
}
