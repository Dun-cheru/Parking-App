package com.example.parkingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class FeedBack extends AppCompatActivity {

    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);

        submit = findViewById(R.id.submit);

        submit.setOnClickListener(View->{
            Toast.makeText(FeedBack.this, "Your Feedback is sent", Toast.LENGTH_SHORT).show();
        });
    }
}