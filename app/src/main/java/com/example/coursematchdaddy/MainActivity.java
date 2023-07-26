package com.example.coursematchdaddy;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import com.example.coursematchdaddy.clean_architecture_layers.controllers.classes.LoginController;
import com.example.coursematchdaddy.clean_architecture_layers.presenters.classes.LoginPresenter;

public class MainActivity extends AppCompatActivity {

    // Declare references to the UI elements
    private TextView titleTextView;
    private Button loginButton;
    private Button signupButton;
    private EditText usernameEditText;
    private EditText passwordEditText;
    private EditText signupUsernameEditText;
    private EditText emailEditText;
    private EditText signupPasswordEditText;
    private TextView importantText;

    // Declare references to the presenter and controller
    private LoginPresenter presenter;
    private LoginController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize references to the UI elements
        titleTextView = findViewById(R.id.textView2);
        loginButton = findViewById(R.id.loginButton);
        signupButton = findViewById(R.id.signupButton);
        usernameEditText = findViewById(R.id.editTextUsername);
        passwordEditText = findViewById(R.id.editTextPassword);
        signupUsernameEditText = findViewById(R.id.editTextSignupUsername);
        emailEditText = findViewById(R.id.editTextEmail);
        signupPasswordEditText = findViewById(R.id.editTextSignupPassword);
        importantText = findViewById(R.id.importantMessage);

        // Initialize the presenter and controller
        presenter = new LoginPresenter();
        controller = new LoginController(presenter);

        // Set click listeners for the login and signup buttons
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve user input from the UI
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Store the user input in the controller
                controller.storeUsername(username);
                controller.storePassword(password);

                // Validate the login data
                boolean loginSuccessful = controller.validateData();

                // Update the UI with the display message from the presenter
                importantText.setText(presenter.getDisplayMessage());

                if (loginSuccessful) {
                    // TODO: Navigate to the main application screen upon successful login
                    // Cant do this yet since other views have not been made
                }
            }
        });

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve user input from the UI
                String signupUsername = signupUsernameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String signupPassword = signupPasswordEditText.getText().toString();

                // Store the user input in the controller
                controller.storePassword(signupPassword);
                controller.storeUsername(signupUsername);
                controller.storeEmail(email);

                // Create a new account and update the UI with the display message from the presenter
                boolean accountCreated = controller.createAccount();
                importantText.setText(presenter.getDisplayMessage());
            }
        });
    }
}
