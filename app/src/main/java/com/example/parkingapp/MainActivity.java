package com.example.parkingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.text.TextUtils;

import android.widget.Button;

import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText LoginEmail;
    EditText LoginPassword;
    Button SignIn;
    Button SignUp;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize
        mAuth = FirebaseAuth.getInstance();

        LoginEmail = findViewById(R.id.LoginEmail);
        LoginPassword = findViewById(R.id.LoginPassword);
        SignUp = findViewById(R.id.signUp);
        SignIn = findViewById(R.id.signIn);
        //SignUp = findViewById(R.id.signUp);

        SignIn.setOnClickListener(view -> {
            loginUser();
        });
        SignUp.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, Sign_Up.class));
        });
    }
    private void loginUser(){
        String email = LoginEmail.getText().toString();
        String password = LoginPassword.getText().toString();

        if (TextUtils.isEmpty(email)){
            LoginEmail.setError("Email cannot be empty");
            LoginEmail.requestFocus();
        }
        else if(TextUtils.isEmpty(password)){
            LoginPassword.setError("Password cannot be empty");
            LoginPassword.requestFocus();
        }else{
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(MainActivity.this, "User Logged in successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, Homepage.class));
                    }else{
                        Toast.makeText(MainActivity.this, "Log in Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}