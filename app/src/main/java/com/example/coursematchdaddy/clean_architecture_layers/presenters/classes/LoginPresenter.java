package com.example.coursematchdaddy.clean_architecture_layers.presenters.classes;

import com.example.coursematchdaddy.clean_architecture_layers.controllers.classes.LoginController;

public class LoginPresenter {

    private LoginController controller;
    private String email;
    private String password;
    private String userName;

    /**
     * Constructs a LoginPresenter object with the given LoginController instance.
     *
     * @param controller A LoginController instance.
     */
    public LoginPresenter(LoginController controller){
        this.controller = controller;
    }

    /**
     * Collects input data from the view and stores it within the presenter.
     *
     * @param email The email entered by the user in the view.
     * @param password The password entered by the user in the view.
     * @param userName The username entered by the user in the view.
     */
    public void collectInputData(String email, String password, String userName){
        this.email = email;
        this.password = password;
        this.userName = userName;
    }


    /**
     * Verifies login data using the controller.
     *
     * @return true if the provided credentials are correct.
     */
    public boolean requestVerification(){
        return controller.validateData(this.email, this.password);
    }

    /**
     * Private method for handling the view update upon a successful login or other view changes.
     * The actual implementation of this method will be added later.
     */
    private void changeView(){

    }
}
