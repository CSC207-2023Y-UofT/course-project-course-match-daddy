package com.example.coursematchdaddy;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.user_subclasses.GuestUser;
import com.example.coursematchdaddy.clean_architecture_layers.gateways.classes.UserDB;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class UserDBTest  {

    @Test
    public void testCheckEmailUniqueness() {
        User user = new GuestUser();
        UserDB db = new UserDB();

        assertTrue(db.checkEmailUniqueness(user.getEmail()));
        db.removeUser(user);
    }

    @Test
    public void testCheckUsernameUniqueness() {
        User user = new GuestUser();
        UserDB db = new UserDB();

        assertTrue(db.checkUsernameUniqueness(user.getUsername()));
        db.removeUser(user);
    }

    @Test
    public void testUpdateUserData() {
        User user = new GuestUser();
        UserDB db = new UserDB();

        user.updateUserPassword("123123");
        assertTrue(db.updateUserData(user));
        db.removeUser(user);
    }

    @Test
    public void testVerifyUser() {
        User user = new GuestUser();
        UserDB db = new UserDB();
        db.removeUser(user);

        // assert that the user was written to the database correctly
        assertTrue(db.verifyUser(user));
        db.removeUser(user);
    }

    @Test
    public void testVerifyUserProvidedData() {
        User user = new GuestUser();
        UserDB db = new UserDB();

        assertFalse(db.verifyUserProvidedData(user.getUsername(), user.getPassword()));

        db.verifyUser(user);

        assertTrue(db.verifyUserProvidedData(user.getUsername(), user.getPassword()));
        db.removeUser(user);
    }

    @Test
    public void testGetUserData() {
        User user = new GuestUser();
        UserDB db = new UserDB();

        db.verifyUser(user);

        assertNotNull(db.getUserData(user.getEmail()));
        db.removeUser(user);
    }

    @Test
    public void testGetUserFromDB() {
        User user = new GuestUser();
        UserDB db = new UserDB();

        db.verifyUser(user);

        assertNotNull(db.getUserFromDB(user.getUsername()));
        db.removeUser(user);
    }

    @Test
    public void testRemoveUser() {
        User user = new GuestUser();
        UserDB db = new UserDB();

        // assert that the user was removed from the database correctly
        assertTrue(db.removeUser(user));
    }
}