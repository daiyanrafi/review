package com.example.piffood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SingIn_Activity extends AppCompatActivity {

    EditText editTextTextEmailAddress, editTextTextPassword;
    Button btnregister;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_in);

        getSupportActionBar().setTitle("Sign In");

        editTextTextEmailAddress = (EditText) findViewById(R.id.editTextTextEmailAddress);
        editTextTextPassword = (EditText) findViewById(R.id.editTextTextPassword);
        btnregister = (Button) findViewById(R.id.btnregister);

        DB = new DBHelper(this);

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = editTextTextEmailAddress.getText().toString();
                String pass = editTextTextPassword.getText().toString();

                if(email.equals("")||pass.equals(""))
                    Toast.makeText(SingIn_Activity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuserpass = DB.checkusernamepassword(email, pass);
                    if(checkuserpass==true){
                        Toast.makeText(SingIn_Activity.this, "Sign in Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(SingIn_Activity.this, "Invalid", Toast.LENGTH_SHORT).show();
                    }
                }



            }
        });

    }
}