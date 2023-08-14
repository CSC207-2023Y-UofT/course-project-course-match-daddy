
package com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.user_subclasses.LoggedInUser;
import com.example.coursematchdaddy.clean_architecture_layers.entities.interfaces.user_class_imports_implementations.AdministrationUserInterface;
import com.example.coursematchdaddy.clean_architecture_layers.entities.interfaces.user_class_imports_implementations.GuestUserInterface;
import com.example.coursematchdaddy.clean_architecture_layers.entities.interfaces.user_class_imports_implementations.LoggedInUserInterface;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.login_class_imports_implementations.CollectLoginDataInterface;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.login_class_imports_implementations.CreateUserAccountInterface;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.login_class_imports_implementations.ExtractUserDataInterface;

import java.util.HashMap;

public abstract class Login implements LoggedInUserInterface, GuestUserInterface, AdministrationUserInterface {

    private final String username;
    private final String password;
    private final String email;
    private final User user;

    /**
     * Constructs a new Login instance with the provided login credentials.
     * As well as a user object to represent the user trying to log in.
     *
     * @param username The username of the user for the login.
     * @param password The password of the user for the login.
     * @param email The email of the user for the login.
     */
    public Login(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        // I assume <User> will not be abstract. If it is, I'll need to make a slight modification
        this.user = new LoggedInUser(this.username, this.email, this.password);
    }

    /**
     * Returns the username associated with this login.
     *
     * @return The username of the user for this login.
     */
    protected String getUsername() {
        return username;
    }

    /**
     * Returns the password associated with this login.
     *
     * @return The password of the user for this login.
     */
    protected String getPassword() {
        return password;
    }

    /**
     * Returns the email associated with this login.
     *
     * @return The email of the user for this login.
     */
    protected String getEmail() {
        return email;
    }

    /**
     * Returns the User object representing the user associated with this login.
     *
     * @return The User object associated with this login.
     */
    protected User getUser() {
        return this.user;
    }

    @Override
    public HashMap<String, Object> getLoginCredentials() {
        HashMap<String, Object> credentials = new HashMap<>();
        credentials.put("username", this.username);
        credentials.put("email", this.email);
        credentials.put("password", this.password);
        return credentials;
    }


    @Override
    public HashMap<String, Object> getUserData() {
        HashMap<String, Object> userDataMap = new HashMap<>();
        userDataMap.put(this.user.getUsername(), this.user);
        return userDataMap;
    }

    @Override
    public HashMap<String, Object> getUsersDataMap() {
        HashMap<String, Object> userDataMap = new HashMap<>();
        userDataMap.put(this.user.getUsername(), this.user);
        return userDataMap;
    }

}
