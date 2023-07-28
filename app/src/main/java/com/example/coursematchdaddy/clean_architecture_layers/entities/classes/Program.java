package com.example.coursematchdaddy.clean_architecture_layers.entities.classes;

import java.io.Serializable;

public class Program implements Serializable {
    private final String programTitle;
    private final String programCode;
    private final String programDescription;

    /**
     * @param programTitle: String
     * @param programCode: String
     * @param programDescription: String
     */
    public Program(String programTitle, String programCode, String programDescription) {
        this.programTitle = programTitle;
        this.programCode = programCode;
        this.programDescription = programDescription;
    }

    /**
     * return program title (ex. Computer Science Specialist)
     * @return String
     */
    public String getProgramTitle() {
        return this.programTitle;
    }

    /**
     * return program code (ex. ERSPE1688)
     * @return String
     */
    public String getProgramCode() {
        return this.programCode;
    }

    /**
     * return program description (ex. This program provides...)
     * @return String
     */
    public String getProgramDescription() {
        return this.programDescription;
    }

}
