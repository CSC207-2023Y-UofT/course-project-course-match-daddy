package com.example.coursematchdaddy.databases;

import android.util.Log;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.user_subclasses.LoggedInUser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class UserDB {
    private String path = "/Users/vorad/AndroidStudioProjects/course-project-course-match-daddy/app/src/main/java/com/example/coursematchdaddy/databases/UserInfo.csv";
    private String pathname = "/data/user/0/com.example.coursematchdaddy/files/UserInfo.csv";

    public User matchUser(String username) {

        // hashmap containing username : User key pair values
        HashMap<String, User> userDB = readUserDB(pathname);
//        Log.e("This worked", "Correct!");
        if (userDB != null) {
            // iterating through hashmap to find user and returning if it exists
            Set set = userDB.entrySet();

            for (Object o : set) {
                Map.Entry entry = (Map.Entry) o;

                if (entry.getKey() == username) {
                    return (User) entry.getValue();
                }
            }
        }

        return null;
    }

    private HashMap<String, User> readUserDB(String filepath) {
        File file = new File(pathname);
        try {
            // creating file if non-existent
            if (!file.exists()) { file.createNewFile(); }

            // reading stream
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            // converting to hashmap
            HashMap<String, User> userDB = (HashMap) objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();

            return userDB;
        } catch (ClassNotFoundException | IOException ex) {
            Log.e("ERROR", ex.getMessage());
            throw new RuntimeException(ex);
        }
    }

    public boolean writeUser(User user) {
        HashMap<String, User> userDB = readUserDB(pathname);
        if (userDB != null) {
            // iterating through hashmap to find user and declining writing privileges if user of same
            // username exists
            Set set = userDB.entrySet();

            for (Object o : set) {
                Map.Entry entry = (Map.Entry) o;

                if (entry.getKey() == user.getUsername()) {
                    return false;
                }
            }
        }
        // writing the user to the file
        return writeUser(user, pathname);
    }

    private boolean writeUser(User user, String filepath) {
        File file = new File(filepath);

        try {
            // creating file if non-existent
            if (!file.exists()) { file.createNewFile(); }

            // starting writers
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            // writing serialized object
            objectOutputStream.writeObject(user);

            // closing writers
            objectOutputStream.close();
            fileOutputStream.close();

            return true;
        } catch (IOException ex) {
            // if file does not exist, write to nothing
//            Log.e("ERROR", "FILE NOT FOUND");
            throw new RuntimeException(ex);
        }
    }

}
