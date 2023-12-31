package com.example.coursematchdaddy.clean_architecture_layers.entities.classes.program_subclasses;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.user_subclasses.GuestUser;

public class Type1ProgramTest {
    @Test
    public void test_basic_info() {
        Type1Program program = new Type1Program("Religion", "ERMAJ0151", "Religion major", "RLG101");

        assertEquals(program.getProgramCode(), "ERMAJ0151");
        assertEquals(program.getProgramDescription(), "Religion major");
        assertEquals(program.getProgramTitle(), "Religion");
        assertEquals(program.getCompletionRequirements(), "RLG101");
        assertEquals((int)program.getRelevance(), 0);

        program.setRelevance(1);

        assertEquals((int)program.getRelevance(), 1);
    }

    @Test
    public void test_enrollment() {
        Type1Program program = new Type1Program("Religion", "ERMAJ0151", "Religion major", "RLG101");
        User temp = new GuestUser();
        program.enroll(temp);

        assertEquals(temp.getSelectedPrograms().get(program.getProgramTitle()), program);
    }


}