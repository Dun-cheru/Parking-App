package com.example.parkingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Sign_Up extends AppCompatActivity {

    FirebaseAuth mAuth;
    Button Register;
    Button signUp;
    EditText RegEmail, RegPassword, RegName, RegPhone, RegPlate;
    FirebaseDatabase database;
    DatabaseReference reference;
    private static final String USER = "user";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();
        RegEmail = findViewById(R.id.RegEmail);
        RegPassword = findViewById(R.id.RegPassword);
        Register = findViewById(R.id.Register);
        signUp = findViewById(R.id.Register);
        RegName = findViewById(R.id.name);
        RegPhone = findViewById(R.id.Phone);
        RegPlate = findViewById(R.id.CarPlate);

        reference = FirebaseDatabase.getInstance().getReference().child(USER);
//        reference = database.getReference(USER);


        signUp.setOnClickListener(view ->{
            createUser();
        });

    }

    private void createUser(){

        //Getting all the values
        String name = RegName.getText().toString();
        String email = RegEmail.getText().toString();
        String password = RegPassword.getText().toString();
        String phone = RegPhone.getText().toString();
        String CarPlate = RegPlate.getText().toString();


        if (TextUtils.isEmpty(name)){
            RegName.setError("Name cannot be empty");
            RegName.requestFocus();
        }
        else if(TextUtils.isEmpty(email)){
            RegEmail.setError("Email cannot be empty");
            RegEmail.requestFocus();
        }
        else if(TextUtils.isEmpty(password)){
            RegPassword.setError("Password cannot be empty");
            RegPassword.requestFocus();
        }
        else if(TextUtils.isEmpty(phone)){
            RegPhone.setError("Phone number cannot be empty");
            RegPhone.requestFocus();
        }
        else if(TextUtils.isEmpty(CarPlate)){
            RegPlate.setError("Plate No cannot be empty");
            RegPlate.requestFocus();
        }else{
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(Sign_Up.this, "User Registered successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Sign_Up.this, MainActivity.class));
                    }else{
                        Toast.makeText(Sign_Up.this, "Registration Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}