package com.example.upskillforfree;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class Register_activity extends AppCompatActivity {

    private Button loginbutton3;
    private EditText regusername,regpassword;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        loginbutton3 = findViewById(R.id.loginbutton3);
        regusername = findViewById(R.id.regusername);
        regpassword = findViewById(R.id.regpassword);

    }
}