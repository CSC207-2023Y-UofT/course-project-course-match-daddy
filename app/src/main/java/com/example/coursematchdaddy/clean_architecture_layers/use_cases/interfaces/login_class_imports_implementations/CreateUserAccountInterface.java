package com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.login_class_imports_implementations;

import com.example.coursematchdaddy.clean_architecture_layers.gateways.classes.DBUsersGateway;

public interface CreateUserAccountInterface {

    final static DBUsersGateway gateway = new DBUsersGateway();
    
    boolean addUsername(String username);
    boolean addPassword(String password);
    boolean addEmail(String email);

}
