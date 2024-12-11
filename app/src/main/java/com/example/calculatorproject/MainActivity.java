package com.example.calculatorproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText passwordEditText, emailEditText;
    Button submitButton;
    static final String CORRECT_PASSWORD = "123456";
    static final String CORRECT_EMAIL = "amine123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        passwordEditText = findViewById(R.id.etLogin);
        submitButton = findViewById(R.id.btnValider);
        emailEditText = findViewById(R.id.usernameEditText);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredPassword = passwordEditText.getText().toString();
                String enteredEmail = emailEditText.getText().toString();


                if (enteredPassword.equals(CORRECT_PASSWORD) && enteredEmail.equals(CORRECT_EMAIL)) {
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Email ou mot de passe incorrect. Vérifiez les majuscules !", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

