package com.example.piffood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SingIn_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_in);

        getSupportActionBar().setTitle("Sign In");

    }
}