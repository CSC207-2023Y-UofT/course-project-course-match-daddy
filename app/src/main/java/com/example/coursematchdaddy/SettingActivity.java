package com.example.coursematchdaddy;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coursematchdaddy.clean_architecture_layers.presenters.classes.SettingsPresenter;

import java.util.HashMap;

public class SettingActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    private Button save;
    private HashMap<String, String> inputFields;
    private SettingsPresenter presenter;

    public SettingActivity(SettingsPresenter presenter) {
        super();
        this.presenter = presenter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);


        inputFields.put("username", ((EditText) findViewById(R.id.username)).getText().toString());
        inputFields.put("email", ((EditText) findViewById(R.id.email)).getText().toString());
        inputFields.put("password", ((EditText) findViewById(R.id.password)).getText().toString());
        inputFields.put("programOfStudy", ((EditText) findViewById(R.id.programOfStudy)).getText().toString());
        inputFields.put("numOfCredits", ((EditText) findViewById(R.id.numOfCredits)).getText().toString());

        save = (Button)findViewById(R.id.save);
        radioGroup = (RadioGroup)findViewById(R.id.groupradio);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (presenter.validateInfo(inputFields)) {
                    // take the user info and do some shit with it
                }
            }
        });


    }
}
