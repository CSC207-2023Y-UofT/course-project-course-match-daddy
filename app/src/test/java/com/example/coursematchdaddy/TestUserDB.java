package com.example.coursematchdaddy;

import org.junit.Test;
import static org.junit.Assert.*;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.user_subclasses.LoggedInUser;
import com.example.coursematchdaddy.databases.UserDB;

public class TestUserDB {

    @Test
    public void reading_user() {
        User user = new LoggedInUser("dev", "devvora@gmail.com", "123");

        UserDB db = new UserDB();
        assertNull(db.matchUser(user.username));

        db.writeUser(user);

        assertEquals(db.matchUser(user.username).username, user.username);
    }

}
