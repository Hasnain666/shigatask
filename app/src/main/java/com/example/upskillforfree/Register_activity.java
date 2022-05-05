package com.example.upskillforfree;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class Register_activity extends AppCompatActivity {

    private Button loginbutton3,newuser;
    private EditText regusername,regpassword;
    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        loginbutton3 = findViewById(R.id.loginbutton3);
        mAuth = FirebaseAuth.getInstance();
        regusername = findViewById(R.id.regusername);
        regpassword = findViewById(R.id.regpassword);
        newuser = findViewById(R.id.newuser);
        loginbutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register();
            }
        });

        newuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Register_activity.this,loginactivity.class));
                finish();
            }
        });


    }

    private void Register() {
        String user = regusername.getText().toString().trim();
        String pass = regpassword.getText().toString().trim();
        if(user.isEmpty())
        {
            regusername.setError("Username Cannot Be Empty");
        }
        else if (pass.isEmpty())
        {
            regpassword.setError("Password Cannot Be Empty");
        }
        else{
            mAuth.createUserWithEmailAndPassword(user,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful())
                    {
                        Toast.makeText(Register_activity.this, "User Registered Successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Register_activity.this,MainActivity.class));
                        finish();
                    }
                    else {
                        Toast.makeText(Register_activity.this, "Registration Failed" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
