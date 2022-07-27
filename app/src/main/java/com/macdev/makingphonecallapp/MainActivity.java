package com.macdev.makingphonecallapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    //Declaration and initialization

    Button contactBtn, customCall;
    private static final int REQUEST_PHONE_CALL= 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





//      Finding Ids.....
        contactBtn = findViewById(R.id.contactBtn);
        customCall = findViewById(R.id.customCall);




        // on click listeners...
        contactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                // intent to make call.....
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:+923167377093"));

                // check for the permissions if they exist.'
                if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){

                    // Request for permissions.......
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_PHONE_CALL);
                }else{

                    // Starting activity .... for making call
                    startActivity(callIntent);
                }
            }
        });


        customCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // activity changing...
                Intent intent = new Intent(MainActivity.this, CustomNumberCall.class);
                startActivity(intent);

            }
        });
    }
}