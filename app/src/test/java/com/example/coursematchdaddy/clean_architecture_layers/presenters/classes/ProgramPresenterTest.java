package com.example.coursematchdaddy.clean_architecture_layers.presenters.classes;

import static org.junit.Assert.assertEquals;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Program;
import com.example.coursematchdaddy.clean_architecture_layers.presenters.classes.ProgramPresenter;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProgramPresenterTest {
    @Test
    public void testProgramPresenter() {
        List<Program> programs = new ArrayList<>();
        programs.add(new Program("Religion", "ERMAJ0151", "Religion major", "RLG101"));
        programs.add(new Program("Computer Science", "ERSPE1688", "Computer Science major", "CSC148 MAT102"));
        HashMap<String, Program> programList = new HashMap<>();

        for (Program program : programs) {
            programList.put(program.getProgramTitle(), program);
        }



        ProgramPresenter presenter = new ProgramPresenter(programList);

        // test population of programList
        for (Program program : programs) {
            assertEquals(presenter.getProgramData().get(program.getProgramTitle()), program);
        }
    }
}
