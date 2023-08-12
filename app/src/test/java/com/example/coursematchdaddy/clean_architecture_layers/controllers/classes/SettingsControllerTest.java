package com.example.coursematchdaddy.clean_architecture_layers.controllers.classes;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Program;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.course_subclasses.ArtsAndSciencesCourse;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.program_subclasses.Type1Program;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.user_subclasses.LoggedInUser;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.login_class_imports_implementations.CreateUserAccountInterface;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.login_class_imports_implementations.ExtractUserDataInterface;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.login_class_imports_implementations.VerifyLoginDataInterface;


import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Map;

public class SettingsControllerTest extends TestCase {

    public static final String USERNAME = "example";
    public static final String EMAIL = "example@mail.com";
    public static final String PASSWORD = "password";
    public void testCollectSettingsData() {
        String username = "exampleUser";
        String email = "example@mail.com";
        String password = "password";
        HashMap<String, String> inputField = new HashMap<>();



        username = "newUser";
        email = "new@mail.com";
        password = "newpassword";

        //Inserting new info into inputField
        inputField.put("username", username);
        inputField.put("email", email);
        inputField.put("password", password);
        inputField.put("coursesTaken", "ISP100");
        inputField.put("numOfCredits", "2.0");
        inputField.put("programOfStudy", "Comp Sci");

        ExtractUserDataInterfaceMock extract = new ExtractUserDataInterfaceMock();
        VerifyLoginDataInterfaceMock verify  = new VerifyLoginDataInterfaceMock();
        CreateUserAccountInterfaceMock create = new CreateUserAccountInterfaceMock();

        SettingsController controller = new SettingsController(username, inputField, extract, create, verify);

        boolean success = controller.collectSettingsData();
        assertTrue(success);

    }

    public void testGetUsername() {
        HashMap<String, String> inputField = new HashMap<>();



        //Inserting new info into inputField
        inputField.put("username", USERNAME);
        inputField.put("email", EMAIL);
        inputField.put("password", PASSWORD);
        inputField.put("coursesTaken", "ISP100");
        inputField.put("numOfCredits", "2.0");
        inputField.put("programOfStudy", "Comp Sci");

        ExtractUserDataInterfaceMock extract = new ExtractUserDataInterfaceMock();
        VerifyLoginDataInterfaceMock verify  = new VerifyLoginDataInterfaceMock();
        CreateUserAccountInterfaceMock create = new CreateUserAccountInterfaceMock();

        SettingsController controller = new SettingsController(USERNAME, inputField, extract, create, verify);

        String resultingUsername = controller.getUsername();
        assertEquals(USERNAME, resultingUsername);
    }

    // Mock implementation of VerifyLoginDataInterface for testing
    private class VerifyLoginDataInterfaceMock implements VerifyLoginDataInterface {
        @Override
        public boolean verifyUserProvidedData(String username, String password) {
            // Mocking the verification process, always returning true for testing purposes
            return true;
        }

        @Override
        public boolean checkEmailUniqueness(String providedEmail) {
            return true;//For testing purposes
        }

        @Override
        public boolean checkUsernameUniqueness(String providedUsername) {
            return true;//For testing purposes
        }
    }

    // Mock implementation of CreateUserAccountInterface for testing
    private class CreateUserAccountInterfaceMock implements CreateUserAccountInterface {

        @Override
        public boolean updateUserData(User userData) {
            return true;//For testing purposes
        }

        @Override
        public boolean verifyUser(User user) {
            return true;//For testing purposes
        }

        @Override
        public boolean removeUser(User user) {
            return true;//For testing purposes
        }
    }

    //Mock implementation of ExtractUserDataInterface for testing
    private class ExtractUserDataInterfaceMock implements ExtractUserDataInterface {

        @Override
        public User getUserData(String email) {
            User user = new LoggedInUser(USERNAME, EMAIL, PASSWORD);

            Map<String, Course> selectedCourses = new HashMap<>();
            Course tempCourse = new ArtsAndSciencesCourse("Writing", "ISP100", "Good", "/", new HashMap<>() );
            selectedCourses.put(tempCourse.getCourseTitle(), tempCourse);

            Map<String, Program> selectedPrograms = new HashMap<>();
            Program tempProgram = new Type1Program("English", "ENG", "good", "Nothing");
            selectedPrograms.put(tempProgram.getProgramTitle(), tempProgram);

            user.updateUserSelectedCourses(selectedCourses);
            user.updateUserSelectedPrograms(selectedPrograms);

            return user;
        }

        @Override
        public User getUserFromDB(String username) {
            User user = new LoggedInUser(USERNAME, EMAIL, PASSWORD);
            Map<String, Course> selectedCourses = new HashMap<>();
            Course tempCourse = new ArtsAndSciencesCourse("Writing", "ISP100", "Good", "/", new HashMap<>() );
            selectedCourses.put(tempCourse.getCourseTitle(), tempCourse);

            Map<String, Program> selectedPrograms = new HashMap<>();
            Program tempProgram = new Type1Program("English", "ENG", "good", "Nothing");
            selectedPrograms.put(tempProgram.getProgramTitle(), tempProgram);

            user.updateUserSelectedCourses(selectedCourses);
            user.updateUserSelectedPrograms(selectedPrograms);

            return user;
        }

    }
}

