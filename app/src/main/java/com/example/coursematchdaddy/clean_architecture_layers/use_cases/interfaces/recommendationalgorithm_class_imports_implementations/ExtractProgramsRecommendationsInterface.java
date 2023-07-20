package com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.recommendationalgorithm_class_imports_implementations;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Program;

public interface ExtractProgramsRecommendationsInterface {
    public String getTitle(Program programData);
    public String getCode(Program programData);
    public String getDescription(Program programData);
    public String getImageURL(Program programData);
}
