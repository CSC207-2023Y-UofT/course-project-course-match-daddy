package com.example.coursematchdaddy.clean_architecture_layers.gateways.classes;

import android.annotation.SuppressLint;
import android.util.Log;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.login_class_imports_implementations.CreateUserAccountInterface;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.login_class_imports_implementations.ExtractUserDataInterface;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.login_class_imports_implementations.VerifyLoginDataInterface;

import java.io.*;
import java.util.HashMap;
import java.util.Objects;

public class UserDB implements VerifyLoginDataInterface, ExtractUserDataInterface, CreateUserAccountInterface {
    @SuppressLint("SdCardPath")
    private final String pathname = "/data/user/0/com.example.coursematchdaddy/files/userdata.csv";

    public UserDB() {
    }

    private HashMap<String, User> readUserDB() {
        File file = new File(pathname);

        // if file doesnt exist, just return an empty
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
     * Return whether the entered username is unique or not
     *
     * @param providedEmail the entered email
     * @return true if the email is unique, false otherwise
     */
    public boolean checkEmailUniqueness(String providedEmail) {
        HashMap<String, User> userDB = readUserDB();

        try {
            // if a user with the given email already exists in the DB, return false
            for (User user : userDB.values()) {
                if (user.getEmail().equals(providedEmail)) {
                    return false;
                }
            }
        } catch (Exception e) {
            Log.e("ERROR", "Error verifying user login: " + e.getMessage());
        }

        return true;
    }

    /**
     * Return whether the entered username is unique or not
     *
     * @param providedUsername the entered username
     * @return true if the email is unique, false otherwise
     */
    @Override
    public boolean checkUsernameUniqueness(String providedUsername) {
        HashMap<String, User> userDB = readUserDB();

        try {
            // if a user with the given email already exists in the DB, return false
            User user = userDB.get(providedUsername);
            if (user != null) {
                return false;
            }
        } catch (Exception e) {
            Log.e("ERROR", "Error verifying user login: " + e.getMessage());
        }

        return true;
    }

    /**
     * Add or update a user within the text file.
     *
     * @param userData This is the provided user's data.
     * @return Return true if this operation is successful.
     */
    @Override
    public boolean updateUserData(User userData) {
        // put new user info into the database
        HashMap<String, User> userDB = readUserDB();
        userDB.put(userData.getUsername(), userData);

        return writeUser(userDB, userData);
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
        if (checkUsernameUniqueness(user.getUsername())) {
            return writeUser(userDB, user);
        } else {
            return false;
        }
    }

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
     * Retrieve a user's data from a database.
     *
     * @param email This is a unique identifier for a user.
     * @return Return a user's data.
     */
    @Override
    public User getUserData(String email) {
        HashMap<String, User> userDB = readUserDB();

        // return the user when email is found in DB, otherwise return null
        for (User user : userDB.values()) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
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
            return userDB.get(providedUsername);
        } catch (Exception e) {
            Log.e("ERROR", "Error verifying user login: " + e.getMessage());
        }

        return null;
    }

    private boolean saveChanges(HashMap<String, User> userDB) {
        File file = new File(pathname);

        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

            // Write serialized object
            objectOutputStream.writeObject(userDB);
            return true;

        } catch (IOException ex) {
            Log.e("ERROR", "Error writing user database: " + ex.getMessage());
        }

        return false;
    }
    /**
     * Removes the specified user from the database.
     *
     * @param user The User object representing the user to be removed.
     * @return True if the user was successfully removed, false otherwise.
     */
    public boolean removeUser(User user) {
        HashMap<String, User> userDB = readUserDB();
        userDB.put(user.getUsername(), null);
        return userDB.get(user.getUsername()) == null && saveChanges(userDB); //removed successfully
    }
}