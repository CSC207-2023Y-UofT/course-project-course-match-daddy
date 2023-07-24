
package com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.login_class_imports_implementations;

public interface CollectLoginDataInterface {

     /**
      * Stores the username provided during the login process.
      *
      * @param username The username entered by the user.
      */
     void storeUsername(String username);

     /**
      * Stores the password provided during the login process.
      *
      * @param password The password entered by the user.
      */
     void storePassword(String password);

     /**
      * Stores the email provided during the login process.
      *
      * @param email The email entered by the user.
      */
     void storeEmail(String email);
}
