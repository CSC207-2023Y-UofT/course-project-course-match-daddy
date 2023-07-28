package com.example.coursematchdaddy.clean_architecture_layers.controllers.classes;

import com.example.coursematchdaddy.clean_architecture_layers.gateways.classes.DBUsersGateway;
import com.example.coursematchdaddy.clean_architecture_layers.presenters.classes.LoginPresenter;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.Login;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.login_subclasses.CreateUserAccount;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes.login_subclasses.VerifyLoginData;
import com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.login_class_imports_implementations.CollectLoginDataInterface;

public class LoginController implements CollectLoginDataInterface {

    private String username;
    private String email;
    private String password;
    private Login verifyLogin;
    private DBUsersGateway accountFactory;
    private LoginPresenter presenter;
    private DBUsersGateway gateway;

    /**
     * Constructs a new LoginController object with the given LoginPresenter instance.
     *
     * @param presenter The LoginPresenter instance associated with this controller.
     */
    public LoginController(LoginPresenter presenter) {
        gateway = new DBUsersGateway();
        this.presenter = presenter;
        this.email = "";
        this.password = "";
        this.username = "";
    }

    @Override
    public void storeUsername(String username) {
        this.username = username;
    }

    @Override
    public void storePassword(String password) {
        this.password = password;
    }

    @Override
    public void storeEmail(String email) {
        this.email = email;
    }

    /**
     * Validates the login data provided by the user.
     * It uses the VerifyLoginData use case to check if the username and password are valid.
     * If the data is valid, sets the display message in the presenter to "Login Validated!",
     * otherwise sets it to "Incorrect username or password, try again!".
     *
     * @return true if the provided credentials are valid, false otherwise.
     */
    public boolean validateData() {
        this.gateway = new DBUsersGateway();
        this.verifyLogin = new VerifyLoginData(this.username, this.password, this.email, this.gateway);

        boolean isValidated = ((VerifyLoginData) verifyLogin).verifyData();
        if (isValidated) {
            presenter.setDisplayMessage("Login Validated!");
        } else {
            presenter.setDisplayMessage("Incorrect username or password, try again!");
        }
        return isValidated;
    }

    /**
     * Creates a new user account using the provided username, email, and password.
     * It uses the CreateUserAccount use case to create the user account.
     * If the account creation is successful, sets the display message in the presenter to
     * "Account successfully created!", otherwise sets it to "Failed to create account, please try again."
     *
     * @return true if the account creation is successful, false otherwise.
     */
    public boolean createAccount() {
        this.gateway = new DBUsersGateway();
        accountFactory = new CreateUserAccount(this.username, this.email, this.password);
        boolean accountCreated = ((CreateUserAccount) accountFactory).createAccount();

        if (accountCreated) {
            presenter.setDisplayMessage("Account successfully created!");
        } else {
            presenter.setDisplayMessage("Failed to create account, please try again.");
        }
        return accountCreated;
    }
}
