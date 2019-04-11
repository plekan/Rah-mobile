package com.example.rah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {
    private Button buttonLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        buttonLogin = findViewById(R.id.buttonLogin);

    }

    public void loginClick(View view){
        if(view == buttonLogin){

            Intent loginIntent = new Intent(this, Dashboard.class);
            startActivity(loginIntent);
        }
    }



}
