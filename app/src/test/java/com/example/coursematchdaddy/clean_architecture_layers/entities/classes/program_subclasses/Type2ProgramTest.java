package com.example.coursematchdaddy.clean_architecture_layers.entities.classes.program_subclasses;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.user_subclasses.GuestUser;

import junit.framework.TestCase;

public class Type2ProgramTest extends TestCase {

    public void testEnroll() {
        Type2Program program = new Type2Program("Religion", "ERMAJ0151", "Religion major", "RLG101");

        assertEquals(program.getProgramCode(), "ERMAJ0151");
        assertEquals(program.getProgramDescription(), "Religion major");
        assertEquals(program.getProgramTitle(), "Religion");
        assertEquals(program.getCompletionRequirements(), "RLG101");
        assertEquals((int)program.getRelevance(), 0);

        program.setRelevance(1);

        assertEquals((int)program.getRelevance(), 1);
    }

    public void testUnenroll() {
        Type2Program program = new Type2Program("Religion", "ERMAJ0151", "Religion major", "RLG101");
        User temp = new GuestUser();
        program.enroll(temp, true);

        assertEquals(temp.getSelectedPrograms().get(program.getProgramTitle()), program);
    }
}