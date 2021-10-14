package com.apps.mobileathentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class EnterPhoneNumberActivity extends AppCompatActivity {
    TextInputEditText editText;
    Button button;
    String number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_phone_number);

        editText = findViewById(R.id.get_mo_number);
        button   = findViewById(R.id.getOTP);
        number   = editText.getText().toString();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editText.getText().toString().trim().equals("")){
                   if(editText.getText().toString().trim().length() == 10) {
                       Intent intent = new Intent(EnterPhoneNumberActivity.this, VerifyMobileNumberActivity.class);
                       intent.putExtra("number",editText.getText().toString());
                       startActivity(intent);
                   }else {
                       Toast.makeText(EnterPhoneNumberActivity.this, "Please Enter Correct Number", Toast.LENGTH_SHORT).show();
                   }
                }else{
                    Toast.makeText(EnterPhoneNumberActivity.this, "Enter Correct Number", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}