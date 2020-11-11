package com.meadberryfarms.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ContactUsActivity extends AppCompatActivity {

    private ImageButton call_btn;
    private String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        userID = getIntent().getStringExtra("userID");

        call_btn=findViewById(R.id.call_btn);
        call_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone="9522332205";
                String s="tel:" +phone;
                Intent intent =new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(s));
                try {
                    startActivity(intent);
                } catch (Exception e) {

                }
                startActivity(intent);
            }
        });
    }
}