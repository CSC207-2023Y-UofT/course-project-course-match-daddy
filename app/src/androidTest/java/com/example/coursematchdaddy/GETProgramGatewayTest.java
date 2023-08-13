package com.example.coursematchdaddy;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import java.util.List;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Program;
import com.example.coursematchdaddy.clean_architecture_layers.gateways.classes.GETProgramGateway;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith(AndroidJUnit4.class)
public class GETProgramGatewayTest {

    @Test
    public void testGetCoursesListData() {
        GETProgramGateway programGateway = new GETProgramGateway();
        List<Program> programList = programGateway.getProgramsListData();
        assertNotNull(programList);
        assertTrue(programList.size() > 0);
    }

    @Test
    public void testParseCSVLine() {
        GETProgramGateway programGateway = new GETProgramGateway();
        String csvLine = "\"Computer Science Specialist\",\"A specialist program in Computer Scie" +
                "nce\",\"ASSPE1689\",\"None\",\"Computer Science\"";
        List<String> fields = programGateway.parseCSVLine(csvLine);

        assertEquals(5, fields.size());
        assertEquals("Computer Science Specialist", fields.get(0));
        assertEquals("A specialist program in Computer Science", fields.get(1));
        assertEquals("ASSPE1689", fields.get(2));
        assertEquals("None", fields.get(3));
        assertEquals("Computer Science", fields.get(4));
    }

}
