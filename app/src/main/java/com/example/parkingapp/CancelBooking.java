package com.example.parkingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CancelBooking extends AppCompatActivity {

    Button search, cancel;
    TextView plotId, slotId, Id, dateId;
    String plot, slot, id, date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel_booking);

        search = findViewById(R.id.search);
        plotId= findViewById(R.id.plotId);
        slotId = findViewById(R.id.slotId);
        Id = findViewById(R.id.Id);
        dateId = findViewById(R.id.DateId);
        cancel = findViewById(R.id.cancel2);

        cancel.setOnClickListener(View ->{
            plotId.setText("Plot: ");
            slotId.setText("Slot: ");
            Id.setText("ID: ");
            dateId.setText("Date: ");
            Toast.makeText(CancelBooking.this, "Booking Cancelled", Toast.LENGTH_SHORT).show();
        });

        //
//        plot = "Plot: Plot 1";
//        slot = "Slot: slot 1";
//        id = "ID: 1424";
//        date = "Date: 10/10/2021";

        plot = "Plot: Plot 1";
        slot = "Slot: slot 2";
        id = "ID: 2986";
        date = "Date: 10/10/2021";

        search.setOnClickListener(View ->{
            plotId.setText(plot);
            slotId.setText(slot);
            Id.setText(id);
            dateId.setText(date);
            Toast.makeText(CancelBooking.this, "Welcome", Toast.LENGTH_SHORT).show();
        });
    }
}