package com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.login_class_imports_implementations;

import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
import com.example.coursematchdaddy.clean_architecture_layers.gateways.classes.DBUsersGateway;

public interface VerifyLoginDataInterface {

    final static DBUsersGateway gateway = new DBUsersGateway();
    boolean verifyUsername(User userData);
    boolean verifyPassword(User userData);
    boolean verifyEmail(User userData);

}
