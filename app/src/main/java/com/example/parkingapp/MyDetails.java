package com.example.parkingapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class MyDetails extends AppCompatActivity {

//    private TextView Name, PhoneNo, Email, Password, PlateNO;
    private Button EditProfile;
    String ed1, ed2, ed3, ed4, ed5, ed6;
    EditText name, phone, email, password, plateNo, valBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_details);


        name = findViewById(R.id.et_name);
        phone = findViewById(R.id.et_phone);
        email = findViewById(R.id.et_email);
        password = findViewById(R.id.et_pass);
        plateNo= findViewById(R.id.et_car);
        valBook = findViewById(R.id.et_valBook);

        EditProfile = findViewById(R.id.profileEdit);


        //Edit names
//        ed1= "Edwin paul";
//        ed2="0705796891";
//        ed3="edwinpaul@gmail.com";
//        ed4="12345678";
//        ed5="KAA 123Z";
//        ed6=" 1424";

        ed1= "Caleb Mumbi";
        ed2="0746459810";
        ed3="alebmumbi@gmail.com";
        ed4="12345678";
        ed5="ZZ 234D";
        ed6="1424";


        EditProfile.setOnClickListener(View ->{
            name.setText(ed1);
            phone.setText(ed2);
            email.setText(ed3);
            password.setText(ed4);
            plateNo.setText(ed5);
            valBook.setText(ed6);
        });

//        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//        if (user != null) {
//            // Name, email address, and profile photo Url
//            String name = user.getDisplayName();
//            String email = user.getEmail();
//
//            // Check if user's email is verified
//            boolean emailVerified = user.isEmailVerified();
//
//            // The user's ID, unique to the Firebase project. Do NOT use this value to
//            // authenticate with your backend server, if you have one. Use
//            // FirebaseUser.getIdToken() instead.
//            String uid = user.getUid();
//        }






    }
}