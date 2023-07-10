package com.example.coursematchdaddy.clean_architecture_layers.entities.classes;

public class Program {
    private String programTitle;
    private String programCode;
    private String programDescription;

    public Program(String programTitle, String programCode, String programDescription) {
        this.programTitle = programTitle;
        this.programCode = programCode;
        this.programDescription = programDescription;
    }

    public String getProgramTitle() {
        return this.programTitle;
    }
    public String getProgramCode() {
        return this.programCode;
    }
    public String getProgramDescription() {
        return this.programDescription;
    }

}
