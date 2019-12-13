package com.example.simplelogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnLogin, btnRegister;
    EditText edtEmail, edtPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);

        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtEmail.getText().toString().equals("admin")&&edtPassword.getText().toString().equals("admin")){
                    Toast.makeText(MainActivity.this, "Login sucessfully", Toast.LENGTH_SHORT).show();
                    onpenHomeScreen();
                }
                else {
                    Toast.makeText(MainActivity.this, " Email or Password is incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Register", Toast.LENGTH_SHORT).show();


            }
        });

    }

    private void onpenHomeScreen(){
        Intent intent = new Intent(MainActivity.this, HomeScreen.class);
        intent.putExtra("email",edtEmail.getText().toString() );
        intent.putExtra("password",edtPassword.getText().toString() );
        startActivity(intent);
    }
}
