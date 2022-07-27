package com.macdev.makingphonecallapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.time.ZoneId;

public class CustomNumberCall extends AppCompatActivity {


    //Declaration and initialization

    private static final int REQUEST_PHONE_CALL = 2;


    Button callBtn;
    EditText numberEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_number_call);


        //      Finding Ids.....
        callBtn = findViewById(R.id.callBtn);
        numberEditText = findViewById(R.id.numberEditText);





        // on click listeners...
        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String phoneNumber = numberEditText.getText().toString();

                // intent to make call.....
                Intent intentCall = new Intent(Intent.ACTION_CALL);
                intentCall.setData(Uri.parse("tel:" + phoneNumber));
                intentCall.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);


                // check for the permissions if they exist.'
                if(ActivityCompat.checkSelfPermission(CustomNumberCall.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){



                    // Request for permissions.......
                    ActivityCompat.requestPermissions(CustomNumberCall.this, new String[]{Manifest.permission.CALL_PHONE},REQUEST_PHONE_CALL );


                }else{

                    // Starting activity .... for making call
                    startActivity(intentCall);


                }
            }
        });





    }
}