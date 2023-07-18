package com.example.coursematchdaddy.clean_architecture_layers.presenters.classes;

import com.example.coursematchdaddy.clean_architecture_layers.controllers.classes.LoginController;

public class LoginPresenter {
    private LoginController controller;
    private String email;
    private String password;
    private String userName;

    public LoginPresenter(LoginController controller){
        this.controller = controller;
    }
    public void collectInputData(){

    }

    public boolean requestVerification(){
        return controller.validateData(this.email, this.password);
    }

    private void changeView(){

    }
}
