package com.example.coursematchdaddy.clean_architecture_layers.gateways.classes;

import android.util.Log;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.login_class_imports_implementations.VerifyLoginDataInterface;

import java.io.*;
import java.util.HashMap;
import java.util.Objects;

public class UserDB implements VerifyLoginDataInterface {
    private final String pathname = "/data/user/0/com.example.coursematchdaddy/files/userdata.csv";

    public UserDB() {
    }

    /**
     * Read the user database from the file and put the information into a hashmap.
     *
     * @return HashMap<String, User>: the hashmap containing all users
     */
    private HashMap<String, User> readUserDB() {
        File file = new File(pathname);

        if (!file.exists()) {
            return new HashMap<>();
        }

        try (FileInputStream fileInputStream = new FileInputStream(file);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            // Convert to hashmap
            Object userDB = objectInputStream.readObject();
            if (userDB instanceof HashMap) {
                return (HashMap<String, User>) userDB;
            } else {
                Log.e("ERROR", "Invalid data format in the user database file.");
            }

        } catch (ClassNotFoundException | IOException ex) {
            Log.e("ERROR", "Error reading user database: " + ex.getMessage());
        }

        return new HashMap<>();
    }

    /**
     * Verify whether the user can be logged in based on the credentials given.
     *
     * @param user the user with the information entered
     * @return whether or not the user can be logged in
     */
    public boolean verifyUser(User user) {
        HashMap<String, User> userDB = readUserDB();

        // If there is a user in the database with the same username, deny the registration
        if (userDB.get(user.getUsername()) == null) {
            return writeUser(userDB, user);
        } else {
            return false;
        }
    }

    /**
     * Write the new user information to the database.
     *
     * @param userDB database
     * @param user   the user that is to be written
     * @return boolean on whether the process was completed
     */
    private boolean writeUser(HashMap<String, User> userDB, User user) {
        File file = new File(pathname);

        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

            // Put user and username into hashmap
            userDB.put(user.getUsername(), user);

            // Write serialized object
            objectOutputStream.writeObject(userDB);
            Log.d("REGISTRATION SUCCESSFUL", "User: " + user.getUsername());
            return true;

        } catch (IOException ex) {
            Log.e("ERROR", "Error writing user database: " + ex.getMessage());
        }

        return false;
    }

    /**
     * Verifies the user's provided log in credentials.
     *
     * @param providedUsername Given username
     * @param providedPassword given password
     * @return true if the username is valid and matches an existing user account, false otherwise.
     */
    @Override
    public boolean verifyUserProvidedData(String providedUsername, String providedPassword) {
        // Hashmap containing username : User key pair values
        HashMap<String, User> userDB = readUserDB();

        try {
            // If username and password exist in DB, and are correct, then return true, otherwise, false
            User user = userDB.get(providedUsername);
            if (user != null && Objects.equals(user.getPassword(), providedPassword)) {
                Log.d("LOGIN SUCCESSFUL", "User: " + user.getUsername());
                return true;
            }
        } catch (Exception e) {
            Log.e("ERROR", "Error verifying user login: " + e.getMessage());
        }

        return false;
    }

    /**
     * Return a User given their username
     *
     * @param providedUsername the username passed in from the Intent
     * @return User object to be returned
     */
    public User getUserFromDB(String providedUsername) {
        // Hashmap containing username : User key pair values
        HashMap<String, User> userDB = readUserDB();

        try {
            // If username and password exist in DB, and are correct, then return true, otherwise, false
            User user = userDB.get(providedUsername);
            return user;
        } catch (Exception e) {
            Log.e("ERROR", "Error verifying user login: " + e.getMessage());
        }

        return null;
    }

    /**
     * Return whether the entered username is unique or not
     *
     * @param providedEmail the entered username
     * @return true if the email is unique, false otherwise
     */
    public boolean checkEmailUniqueness(String providedEmail) {
        HashMap<String, User> userDB = readUserDB();

        try {
            // if a user with the given email already exists in the DB, return false
            User user = userDB.get(providedEmail);
            if (user != null) {
                return false;
            }
        } catch (Exception e) {
            Log.e("ERROR", "Error verifying user login: " + e.getMessage());
        }

        return true;
    }
}
