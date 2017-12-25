package com.arkadiy.enter.imenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class LogInActivity extends AppCompatActivity {
    private EditText editTextName;
    private EditText editTextPassword;
    private Intent intent;
    Button logIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
    }

    public void button_LogIn(View view) {
        Intent i = new Intent (this, MainActivity.class);
        startActivity(i);
    }

}

