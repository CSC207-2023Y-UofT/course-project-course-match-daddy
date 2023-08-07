package com.example.coursematchdaddy.PresenterTests;

import static org.junit.Assert.assertEquals;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Program;
import com.example.coursematchdaddy.clean_architecture_layers.presenters.classes.ProgramPresenter;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestProgramPresenter {
    @Test
    public void testProgramPresenter() {
        List<Program> programList = new ArrayList<>();
        programList.add(new Program("Religion", "ERMAJ0151", "Religion major", "RLG101"));
        programList.add(new Program("Computer Science", "ERSPE1688", "Computer Science major", "CSC148 MAT102"));

        ProgramPresenter presenter = new ProgramPresenter(programList);

        // test population of programList
        assertEquals(presenter.getProgramData().get(1).get("ProgramCode"), programList.get(1).getProgramCode());
        assertEquals(presenter.getProgramData().get(1).get("ProgramTitle"), programList.get(1).getProgramTitle());
        assertEquals(presenter.getProgramData().get(1).get("ProgramDescription"), programList.get(1).getProgramDescription());
    }
}
