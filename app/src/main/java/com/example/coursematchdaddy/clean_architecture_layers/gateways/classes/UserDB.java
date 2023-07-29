package com.example.coursematchdaddy.clean_architecture_layers.gateways.classes;

import android.annotation.SuppressLint;
import android.util.Log;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.login_class_imports_implementations.VerifyLoginDataInterface;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Objects;

public class UserDB implements VerifyLoginDataInterface {
    @SuppressLint("SdCardPath")
    private final String pathname = "/data/user/0/com.example.coursematchdaddy/files/userdata.csv";

    public UserDB() {}
    /**
     * Read the database and put the information into a hashmap
     *
     * @return HashMap<String, User> : the hashmap containing all users
     */
    private HashMap<String, User> readUserDB() {
        File file = new File(pathname);

        try {

            // reading stream
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            // converting to hashmap
            Object userDB = objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();

            if (userDB instanceof HashMap) {
                return (HashMap<String, User>) userDB;
            } else {
                Log.e("ERROR", "Invalid data format in the user database file.");
            }

            return new HashMap<>();

        } catch (ClassNotFoundException | IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Verify whether the user can be logged in based on the credentials given
     *
     * @param user the user with the information entered
     * @return     whether or not the user can be logged in
     */
    public boolean verifyUser(User user) {
        HashMap<String, User> userDB = readUserDB();
        // iterating through hashmap to find user

        // if there is a user in the database with the same username, deny the registration
        if (userDB.get(user.getUsername()) == null) {
            return writeUser(userDB, user);
        }
        else {
            return false;
        }

    }

    /**
     * Write the new user information to the database
     *
     * @param userDB database
     * @param user the user that is to be written
     * @return boolean on whether the process was completed
     */
    private boolean writeUser(HashMap<String, User> userDB, User user) {
        File file = new File(pathname);

        try {

            // starting writers
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            // putting user and username into hashmap
            userDB.put(user.getUsername(), user);

            // writing serialized object
            objectOutputStream.writeObject(userDB);

            Log.d("REGISTRATION SUCCESSFUL", "User: " + user.getUsername());

            // closing writers
            objectOutputStream.close();
            fileOutputStream.close();

            return true;
        } catch (IOException ex) {
            return false;
        }
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
        // hashmap containing username : User key pair values
        HashMap<String, User> userDB = readUserDB();
        try {
            // if username and password exist in DB, and are correct, then return true, otherwise, false
            User user = userDB.get(providedUsername);
            if (Objects.equals(user.getPassword(), providedPassword)) {
                Log.d("LOGIN SUCCESSFUL", "User: " + user.getUsername());
                return true;
            }
        } catch (NullPointerException e)  {
            return false;
        }
        return false;
    }
}