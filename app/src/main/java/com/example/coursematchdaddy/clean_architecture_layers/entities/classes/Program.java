package com.example.coursematchdaddy.clean_architecture_layers.entities.classes;

public class Program {
    private String programTitle;
    private String programCode;
    private String programDescription;

    /**
     * @param programTitle
     * @param programCode
     * @param programDescription
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
