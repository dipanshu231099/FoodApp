package android.example.foodapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.example.foodapp.Model.Users;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PersonInformationActivity extends AppCompatActivity {

    private Button continueBtn;
    private EditText fullName, userMobile, userState, userCity, userCountry, userPin;
    private String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_information);
        userID = getIntent().getStringExtra("userID");
        fullName = findViewById(R.id.info_fullName);
        userMobile = findViewById(R.id.info_mobile);
        userState = findViewById(R.id.info_state);
        userCity = findViewById(R.id.info_city);
        userCountry = findViewById(R.id.info_country);
        userPin = findViewById(R.id.info_pin);
        fillInInfo();
        continueBtn=findViewById(R.id.continueBtn);
        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(PersonInformationActivity.this,PaymentModeActivity.class);
                startActivity((intent));
            }
        });
    }

    private void fillInInfo() {
        final DatabaseReference UserRef = FirebaseDatabase.getInstance().getReference().child("Users");
        UserRef.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Users user = snapshot.getValue(Users.class);
                fullName.setText(user.getUsername());
                userMobile.setText(user.getPhone());
                userCity.setText(user.getCity());
                userPin.setText(user.getPin());
                userCountry.setText("India");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}