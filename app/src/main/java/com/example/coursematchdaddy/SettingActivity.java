package com.example.coursematchdaddy;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coursematchdaddy.clean_architecture_layers.controllers.classes.SettingsController;
import com.example.coursematchdaddy.clean_architecture_layers.gateways.classes.UserDB;
import com.example.coursematchdaddy.clean_architecture_layers.presenters.classes.SettingsPresenter;
import com.google.android.material.snackbar.Snackbar;

import java.util.HashMap;

public class SettingActivity extends AppCompatActivity {
    private EditText usernameEditText, emailEditText, passwordEditText, programOfStudyEditText,
            numOfCreditsEditText, coursesTakenEditText;
    private CheckBox objectiveCheckBox, subjectivityCheckBox, peopleCheckBox, thingsCheckBox,
            detailsCheckBox, bigPictureCheckBox, reportsCheckBox, problemSetsCheckBox,
            creativeCheckBox, thoughtCheckBox, livingThingsCheckBox, physicalMathCheckBox,
            societyInstitutionsCheckBox;
    private String username;// user associated with previous activity.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        // Retrieve the "extra" info from the Intent
        Intent intent = getIntent();
        UserDB db = new UserDB();
        SettingsPresenter presenter = new SettingsPresenter();
        if (intent != null) {
            this.username = intent.getStringExtra("username");// user associated with previous activity.
            Log.d("LOG", "SETTINGSUSERPART@: " + this.username);
        }
        // Find views by their IDs
        usernameEditText = findViewById(R.id.username);
        emailEditText = findViewById(R.id.editTextEmail2);
        passwordEditText = findViewById(R.id.editTextSignupPassword2);
        programOfStudyEditText = findViewById(R.id.programofstudy);
        numOfCreditsEditText = findViewById(R.id.numofcredits);
        coursesTakenEditText = findViewById(R.id.coursestaken);

        objectiveCheckBox = findViewById(R.id.checkBox);
        subjectivityCheckBox = findViewById(R.id.checkBox2);
        peopleCheckBox = findViewById(R.id.checkBox3);
        thingsCheckBox = findViewById(R.id.checkBox4);
        detailsCheckBox = findViewById(R.id.checkBox5);
        bigPictureCheckBox = findViewById(R.id.checkBox6);
        reportsCheckBox = findViewById(R.id.checkBox7);
        problemSetsCheckBox = findViewById(R.id.checkBox8);
        creativeCheckBox = findViewById(R.id.checkBox9);
        thoughtCheckBox = findViewById(R.id.checkBox10);
        livingThingsCheckBox = findViewById(R.id.checkBox11);
        physicalMathCheckBox = findViewById(R.id.checkBox13);
        societyInstitutionsCheckBox = findViewById(R.id.checkBox12);

        ImageButton backButton = findViewById(R.id.buttonBack);

        backButton.setOnClickListener(v -> {
            Intent intent1 = new Intent(SettingActivity.this, CarouselActivity.class);
            intent1.putExtra("username", SettingActivity.this.username);
            startActivity(intent1);
            finish(); // Close the current SettingActivity if needed
        });

        Button saveButton = findViewById(R.id.saveButton);

        // Set onClickListener for the saveButton
        saveButton.setOnClickListener(v -> {
            // Gather input data from EditText views and CheckBoxes
            String username = usernameEditText.getText().toString();
            String email = emailEditText.getText().toString();
            String password = passwordEditText.getText().toString();
            String programOfStudy = programOfStudyEditText.getText().toString();
            String numOfCredits = numOfCreditsEditText.getText().toString();
            String coursesTaken = coursesTakenEditText.getText().toString();

            boolean isObjective = objectiveCheckBox.isChecked();
            boolean isSubjective = subjectivityCheckBox.isChecked();
            boolean isPeople = peopleCheckBox.isChecked();
            boolean isThings = thingsCheckBox.isChecked();
            boolean isDetails = detailsCheckBox.isChecked();
            boolean isBigPicture = bigPictureCheckBox.isChecked();
            boolean isReports = reportsCheckBox.isChecked();
            boolean isProblemSets = problemSetsCheckBox.isChecked();
            boolean isCreative = creativeCheckBox.isChecked();
            boolean isThought = thoughtCheckBox.isChecked();
            boolean isLivingThings = livingThingsCheckBox.isChecked();
            boolean isPhysicalMath = physicalMathCheckBox.isChecked();
            boolean isSocietyInstitutions = societyInstitutionsCheckBox.isChecked();

            // Store input data in a HashMap
            HashMap<String, String> inputFields = new HashMap<>();
            inputFields.put("username", username);
            inputFields.put("email", email);
            inputFields.put("password", password);
            inputFields.put("programOfStudy", programOfStudy);
            inputFields.put("numOfCredits", numOfCredits);
            inputFields.put("coursesTaken", coursesTaken);
            inputFields.put("objective", String.valueOf(isObjective));
            inputFields.put("subjective", String.valueOf(isSubjective));
            inputFields.put("people", String.valueOf(isPeople));
            inputFields.put("things", String.valueOf(isThings));
            inputFields.put("details", String.valueOf(isDetails));
            inputFields.put("bigPicture", String.valueOf(isBigPicture));
            inputFields.put("reports", String.valueOf(isReports));
            inputFields.put("problemSets", String.valueOf(isProblemSets));
            inputFields.put("Creative and Cultural Representations", String.valueOf(isCreative));
            inputFields.put("Thought, Belief, and Behaviour", String.valueOf(isThought));
            inputFields.put("Living Things and Their Environment", String.valueOf(isLivingThings));
            inputFields.put("The Physical and Mathematical Universes", String.valueOf(isPhysicalMath));
            inputFields.put("Society and Its Institutions", String.valueOf(isSocietyInstitutions));
            View rootView = findViewById(android.R.id.content); // The root view of your layout
            String message ="Provide your number of credits and the 3-digit course code for your desired POSt.";
            String errorMessage = "Failed to update settings. Please try again.";//TODO: Make this message more useful to user
            if (!presenter.validateInfo(inputFields)){
                Snackbar.make(rootView, message, Snackbar.LENGTH_SHORT).show();
            }else{
                SettingsController controller = new SettingsController(SettingActivity.this.username, inputFields, db, db, db);
                boolean successful = controller.collectSettingsData();
                if (successful){
                    //Navigate to carousel activity so the user can start getting their recommendations!
                    Snackbar.make(rootView, "Success!", Snackbar.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(SettingActivity.this, CarouselActivity.class);
                    SettingActivity.this.username = controller.getUsername();
                    intent1.putExtra("username", SettingActivity.this.username);
                    startActivity(intent1);
                    finish(); // Close the current SettingActivity if needed
                }else{
                    Snackbar.make(rootView, errorMessage, Snackbar.LENGTH_SHORT).show();
                }
            }
        });
    }
}
