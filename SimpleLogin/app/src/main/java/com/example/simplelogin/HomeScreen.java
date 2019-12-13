package com.example.simplelogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class HomeScreen extends AppCompatActivity {

    TextView tvEmail, tvPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        tvEmail = findViewById(R.id.email);
        tvPassword = findViewById(R.id.password);

        String email = getIntent().getStringExtra("email");
        String password = getIntent().getStringExtra("password");

        tvEmail.setText(email);
        tvPassword.setText(password);


    }
}
