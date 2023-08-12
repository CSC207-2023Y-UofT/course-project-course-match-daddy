package com.example.coursematchdaddy.clean_architecture_layers.entities.classes.program_subclasses;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.user_subclasses.GuestUser;

import junit.framework.TestCase;

public class Type3ProgramTest extends TestCase {
    Type3Program program = new Type3Program("Religion", "ERMAJ0151", "Religion major", "RLG101");

    public void testHasSpace() {
        assertTrue(program.hasSpace());
    }

    public void testEnroll() {
        assertEquals(program.getProgramCode(), "ERMAJ0151");
        assertEquals(program.getProgramDescription(), "Religion major");
        assertEquals(program.getProgramTitle(), "Religion");
        assertEquals(program.getCompletionRequirements(), "RLG101");
        assertEquals((int)program.getRelevance(), 0);

        program.setRelevance(1);

        assertEquals((int)program.getRelevance(), 1);
    }

    public void testUnenroll() {

        User temp = new GuestUser();
        program.enroll(temp, true);

        assertEquals(temp.getSelectedPrograms().get(program.getProgramTitle()), program);
    }
}