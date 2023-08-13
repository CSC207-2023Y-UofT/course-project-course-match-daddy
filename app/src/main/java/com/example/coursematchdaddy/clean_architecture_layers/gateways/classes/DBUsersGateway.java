package com.example.coursematchdaddy.clean_architecture_layers.gateways.classes;


// Reads and writes user data to the database.
public class DBUsersGateway {
    // Define the private attributes for an instance of the User class.
//    private String username; // This is a unique identifier for an instance of the User class.
//    private String email; // This is a unique identifier for an instance of the User class.
//    private String password;
//    private Map<String, Course> selectedCourses;
//    private Map<String, Program> selectedPrograms;

    // Survey-related attributes
//    private String program;
//    private Float numCredits;
//    private List<String> coursesTaken;
//    private List<String> preferences;
//    private Survey userSurvey;

    // Define a map for storing all of the users in the text file.
//    public Map<String, User> usersMap = new HashMap<String, User>();

    //    public DBUsersGateway(){
//         Load users' data from the database and store it in a User object.
//        [insert database connection here]
//
//         For the MVP version of this application, each user is stored in a row on a text file.
//         The text file has the following columns: username, email, password, selectedCourses,
//         selectedPrograms, program, numCredits, coursesTaken, and  preferences.
//
//        [for each user in the text file]:
//            username = [read username];
//            email = [read email];
//            selectedCourses = [read selected courses];
//            selectedPrograms = [read selected programs];
//            program = [read enrolled program];
//            numCredits = [read number of credits];
//            coursesTaken = [read courses taken];
//            preferences = [read preferences];
//
//             Initialize an instance of the UserData subclass of the Survey class
//            userSurvey = new UserData(username, email, password, program, numCredits, coursesTaken, preferences);
//
//            User userData = new LoggedInUser(username, email, password);
//            userData.updateUserSelectedCourses(selectedCourses);
//            userData.updateUserSelectedPrograms(selectedPrograms);
//            userData.updateUserSurveyData(userSurvey);
//
//            // Add the user to the usersMap
//            usersMap.put(username, userData);
//    }

    // These next set of interface methods revolve around verifying a user and modifying the user's data.
    //    public boolean verifyUserProvidedData(String providedUsername, String providedPassword){
//        if (usersMap.containsKey(providedUsername)) {
//            if (this.usersMap.get((String) providedUsername).getPassword().equals(providedPassword)) {
//                return true;
//            }
//        }
//        return false;
//    }

    //    public User getUserData(String username) {
//        if (usersMap.containsKey(username)) {
//            return usersMap.get((String) username);
//        }
//        return null;
//    }

    //    public boolean updateUserData(User userData) {
//        if (this.usersMap.containsKey(userData.getUsername())) {
//            this.usersMap.put(userData.getUsername(), userData);
//            //[update the corresponding row within the text file];
//            return true;
//        }
//        usersMap.put(userData.username, userData);
//        //[update the corresponding row within the text file];
//        return true;
//    }
}
