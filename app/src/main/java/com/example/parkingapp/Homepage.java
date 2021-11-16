package com.example.parkingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Homepage extends AppCompatActivity {
    FirebaseAuth mAuth;
    Button LogOut, NewBook, cancelBook, ViewBook, MyDetails, FeedBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        LogOut = findViewById(R.id.logout);
        mAuth = FirebaseAuth.getInstance();
        NewBook = findViewById(R.id.newBooking);
        cancelBook = findViewById(R.id.Cancel);
        ViewBook = findViewById(R.id.ViewBooking);
        MyDetails = findViewById(R.id.myDetails);
        FeedBack = findViewById(R.id.Feedback);

        LogOut.setOnClickListener(View ->{
            mAuth.signOut();
            startActivity(new Intent(Homepage.this, MainActivity.class));
        });


        NewBook.setOnClickListener(View ->{
            startActivity(new Intent(Homepage.this, ParkingOne.class));
            }
        );


        cancelBook.setOnClickListener(view -> {
            startActivity( new Intent(Homepage.this, CancelBooking.class));
            }
        );
        ViewBook.setOnClickListener(view -> {
                startActivity(new Intent(Homepage.this, CancelBooking.class));
            }
        );

        MyDetails.setOnClickListener(view -> {
            startActivity(new Intent(Homepage.this, MyDetails.class));
            }
        );

        FeedBack.setOnClickListener(view -> {
            startActivity(new Intent(Homepage.this, FeedBack.class));
            }
        );
    }
    @Override
    protected void onStart(){
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user == null){
            startActivity(new Intent(Homepage.this, MainActivity.class));
        }
    }
}