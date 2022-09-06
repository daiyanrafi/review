package com.example.piffood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp_Activity extends AppCompatActivity {


    EditText editTextTextPersonName;
    EditText editTextPhone;
    EditText editTextTextEmailAddress;
    EditText editTextTextPassword;


    TextView btnhaveaccount;
    Button btnregister;
    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        getSupportActionBar().setTitle("Sign Up");

        btnhaveaccount = findViewById(R.id.btnhaveaccount);

        btnhaveaccount = (Button) findViewById(R.id.btnregister);
        editTextPhone = (EditText) findViewById(R.id.editTextPhone);
        editTextTextEmailAddress = (EditText)  findViewById(R.id.editTextTextEmailAddress);
        editTextTextPassword = (EditText) findViewById(R.id.editTextTextPassword);

        DB = new DBHelper(this);

        btnhaveaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(SignUp_Activity.this, SingIn_Activity.class);
                startActivity(myIntent);


                btnregister.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String user = editTextTextPersonName.getText().toString();
                        String phone = editTextPhone.getText().toString();
                        String email = editTextTextEmailAddress.getText().toString();
                        String pass = editTextTextPassword.getText().toString();


                        if(user.equals("")||phone.equals("")||email.equals("")||pass.equals(""))
                            Toast.makeText(SignUp_Activity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                        else {
                            if (pass.equals(pass)) {
                                Boolean checkuser = DB.checkusername(user);
                                if (checkuser == false) {
                                    Boolean insert = DB.insertData(user, pass);
                                    if (insert == true) {
                                        Toast.makeText(SignUp_Activity.this, "Done Successfully", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                                        startActivity(intent);
                                    } else {
                                        Toast.makeText(SignUp_Activity.this, "faield", Toast.LENGTH_SHORT).show();
                                    }
                                } else {
                                    Toast.makeText(SignUp_Activity.this, "already exist", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(SignUp_Activity.this, "password not matching", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
            }
        });


    }
}