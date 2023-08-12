package com.example.coursematchdaddy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import com.example.coursematchdaddy.clean_architecture_layers.controllers.classes.LoginController;
import com.example.coursematchdaddy.clean_architecture_layers.gateways.classes.UserDB;
import com.example.coursematchdaddy.clean_architecture_layers.presenters.classes.LoginPresenter;

import java.io.*;

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
    private UserDB gateway;

    /**
     * Copies a file from the "raw" folder to the internal storage directory of the app.
     *
     * @param context    The Context of the app.
     * @param rawResId   The resource ID of the file in the "raw" folder.
     * @param targetPath The desired path of the copied file within the internal storage.
     * @return True if the file was successfully copied, false otherwise.
     */
    private boolean copyFileFromRawToInternalStorage(Context context, int rawResId, String targetPath) {
        try {
            // Open the raw resource using the resource ID
            InputStream inputStream = context.getResources().openRawResource(rawResId);

            // Get the internal storage directory
            File internalStorageDir = context.getFilesDir();

            // Create the target file inside the internal storage directory
            File targetFile = new File(internalStorageDir, targetPath);

            // Copy if the file doesnt exist
            if (!targetFile.exists()) {
                FileOutputStream outputStream = new FileOutputStream(targetFile);
                // For efficiency, shoudnt matter too much in either case since csv file isnt too large
                byte[] buffer = new byte[1024];
                int bytesRead;

                // WHile theres still stuff to copy
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                outputStream.close();
                inputStream.close();

                Log.d("LOG", "File copied successfully to internal storage: " + targetFile.getAbsolutePath());
                return true;
            } else {
                // Dont rewrite if file already exists
                Log.d("LOG", "File already exists in internal storage: " + targetFile.getAbsolutePath());
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Copy the file from resources to internal storage
        boolean copySuccess = copyFileFromRawToInternalStorage(this, R.raw.artssci, "artssci.csv");
        copySuccess = copyFileFromRawToInternalStorage(this, R.raw.programs, "programs.csv");
        copySuccess = copyFileFromRawToInternalStorage(this, R.raw.math, "math.png");
        copySuccess = copyFileFromRawToInternalStorage(this, R.raw.culture, "culture.png");
        copySuccess = copyFileFromRawToInternalStorage(this, R.raw.living, "living.png");
        copySuccess = copyFileFromRawToInternalStorage(this, R.raw.society, "society.png");
        copySuccess = copyFileFromRawToInternalStorage(this, R.raw.thought, "thought.png");

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
        gateway = new UserDB();
        controller = new LoginController(presenter, gateway, gateway);

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
                    Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                    intent.putExtra("username", username);
                    startActivity(intent);
                    finish(); // Close the current MainActivity if needed
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

                if (accountCreated){
                    Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                    intent.putExtra("username", signupUsername);
                    startActivity(intent);
                    finish(); // Close the current MainActivity if needed
                }
            }
        });
    }
}
