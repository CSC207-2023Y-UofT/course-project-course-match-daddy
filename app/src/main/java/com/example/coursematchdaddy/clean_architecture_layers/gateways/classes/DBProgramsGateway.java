package com.example.coursematchdaddy.clean_architecture_layers.gateways.classes;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Program;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.swipecarousel_class_imports_implementations.ExtractProgramDataInterface;

public class DBProgramsGateway implements ExtractProgramDataInterface {
    @Override
    public String getTitle(Program programData) {
        return null;
    }

    @Override
    public String getCode(Program programData) {
        return null;
    }

    @Override
    public String getDescription(Program programData) {
        return null;
    }
}
