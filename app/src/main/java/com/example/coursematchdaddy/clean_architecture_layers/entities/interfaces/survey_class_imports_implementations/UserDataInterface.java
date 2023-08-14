package com.example.coursematchdaddy.clean_architecture_layers.entities.interfaces.survey_class_imports_implementations;



import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Program;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Survey;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.login_class_imports_implementations.CreateUserAccountInterface;

import java.util.Map;


public interface UserDataInterface {
    boolean updateSettings(String username, String email, String password, Map<String, Course> selectedCourses, Map<String, Program> selectedPrograms, Survey userSurvey, CreateUserAccountInterface db);

}
