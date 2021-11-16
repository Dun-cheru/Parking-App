package com.example.parkingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class PlotOne extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    TextView tvDate, tvTime, txtView;
    EditText etDate, etTime;
    DatePickerDialog.OnDateSetListener setListener;
    Button slotOne, slotTwo, slotThree, slotFour;
    String tv1, tv2, tv3, tv4;
//    private static final String JSON_URL = "https://api.thingspeak.com/channels/1511343/feeds.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plot_one);

//       final Button slotOne = (Button) findViewById(R.id.slotOne);
//       final Button slotTwo = (Button) findViewById(R.id.slotTwo);
//       final Button slotThree = (Button) findViewById(R.id.slotThree);
//       final Button slotFour = (Button) findViewById(R.id.slotFour);

        slotOne = findViewById(R.id.slotOne);
        slotTwo = findViewById(R.id.slotTwo);
        slotThree = findViewById(R.id.slotThree);
        slotFour = findViewById(R.id.slotFour);

        txtView = findViewById(R.id.txtView);
        //sorry parking Booked
//         tv1= "Your ID is 1424";
         tv1= "sorry parking Booked";
         tv2= "Your ID is 2986";
         tv3= "Your ID is 3976";
         tv4= "Your ID is 4064";

       slotOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //change color red
                slotOne.setBackgroundResource(R.color.red);

                slotFour.setBackgroundResource(R.color.white);
                //Toast sorry parking Booked
                Toast.makeText(PlotOne.this,"sorry parking Booked", Toast.LENGTH_LONG).show();
                txtView.setText(tv1);
            }
        });
        slotTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                slotTwo.setBackgroundResource(R.color.lightgreen);
                slotOne.setBackgroundResource(R.color.white);
                Toast.makeText(PlotOne.this,"2986", Toast.LENGTH_LONG).show();
                txtView.setText(tv2);
            }
        });
        slotThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                slotThree.setBackgroundResource(R.color.lightgreen);
                slotTwo.setBackgroundResource(R.color.white);
                Toast.makeText(PlotOne.this,"3976", Toast.LENGTH_LONG).show();
                txtView.setText(tv3);
            }
        });
        slotFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                slotFour.setBackgroundResource(R.color.lightgreen);
                slotThree.setBackgroundResource(R.color.white);
                Toast.makeText(PlotOne.this,"4064", Toast.LENGTH_LONG).show();
                txtView.setText(tv4);
            }
        });






        //Assign Variable
        tvTime = findViewById(R.id.tv_time);
        etTime = findViewById(R.id.et_Time);

        tvDate = findViewById(R.id.tv_Date);
        etDate = findViewById(R.id.et_Date);


        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);


        tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        PlotOne.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, setListener,year,month,day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month+1;
                String date = day+"/"+month+"/"+year;
                tvDate.setText(date);
            }
        };

        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        PlotOne.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month+1;
                        String date = day+"/"+month+"/"+year;
                        etDate.setText(date);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.numbers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}