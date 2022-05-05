package com.example.upskillforfree;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.rey.material.widget.CheckBox;

public class loginactivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText loginusername,loginpassword;
    private ImageView loginapplogo;
    private CheckBox rememberme;
    private TextView forgetpassword;
    private Button loginbutton2,Register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);
        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        mAuth = FirebaseAuth.getInstance();
        loginusername = findViewById(R.id.loginusername);
        loginpassword = findViewById(R.id.loginpassword);
        loginapplogo = findViewById(R.id.loginapplogo);
        forgetpassword = findViewById(R.id.forgetpassword);
        loginbutton2 = findViewById(R.id.loginbutton2);
        Register = findViewById(R.id.register);
        loginbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(loginactivity.this,Register_activity.class));
            }
        });




    }


    private void login() {
        String user = loginusername.getText().toString().trim();
        String pass = loginpassword.getText().toString().trim();
        if(user.isEmpty())
        {
            loginusername.setError("Email can not be empty");
        }
        if(pass.isEmpty())
        {
            loginpassword.setError("Password can not be empty");
        }
        else
        {
            mAuth.signInWithEmailAndPassword(user,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful())
                    {
                        Toast.makeText(loginactivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(loginactivity.this,MainActivity.class));
                        finish();

                    }
                    else {
                        Toast.makeText(loginactivity.this, "Login Failed, Please Try Again" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });



        }

    }
}