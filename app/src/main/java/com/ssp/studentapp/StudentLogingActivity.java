package com.ssp.studentapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class StudentLogingActivity extends AppCompatActivity {

    EditText loginUserName, loginUserPassword;
    Button signUpBtn, signInBtn;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_login_activity);
        //declare section
        loginUserName = findViewById(R.id.loginUserName);
        loginUserPassword = findViewById(R.id.loginUserPwd);
        signUpBtn = findViewById(R.id.siginUpBtn);
        signInBtn = findViewById(R.id.siginInBtn);





    }
}
