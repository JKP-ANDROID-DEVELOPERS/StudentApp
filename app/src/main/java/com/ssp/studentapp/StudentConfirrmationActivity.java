package com.ssp.studentapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class StudentConfirrmationActivity  extends AppCompatActivity {

    TextView studentNameTextView,studentFnameTextView,studentMnameTextView
            ,studentEmailTextView,studentPasswordTextView,studentAADHARTextView
            ,studentClassTextView,studentGenderTextView,studentHobbiesTextView,
            studentReservationTextView;
    Button confirm, back;
    AlertDialog.Builder confirmDialogueBuilder;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle intentData = getIntent().getExtras();
        String studentName = intentData.get("StName").toString();
        String studentFatherName = intentData.get("StFName").toString();
        String studentMotherName = intentData.get("StMName").toString();
        String studentEmail = intentData.get("StEmail").toString();
        String studentPwd = intentData.get("StPwd").toString();
        String studentAADHAR = intentData.get("StAADHAR").toString();
        String studentClass = intentData.get("StClass").toString();
        String studentGender = intentData.get("StGender").toString();
        String studentHobbies = intentData.get("StHobbies").toString();
        //String studentReservation = intentData.get("Reservation").toString();


        setContentView(R.layout.student_confirmation_activity);
        studentNameTextView= findViewById(R.id.stName);
        studentNameTextView.setText(studentName);
        studentFnameTextView= findViewById(R.id.stFName);
        studentFnameTextView.setText(studentFatherName);
        studentMnameTextView= findViewById(R.id.stMName);
        studentMnameTextView.setText(studentMotherName);
        studentEmailTextView= findViewById(R.id.stEmail);
        studentEmailTextView.setText(studentEmail);
        studentPasswordTextView= findViewById(R.id.stPassword);
        studentPasswordTextView.setText(studentPwd);
        studentAADHARTextView= findViewById(R.id.stPassword);
        studentAADHARTextView.setText(studentAADHAR);
        studentHobbiesTextView= findViewById(R.id.stPassword);
        studentHobbiesTextView.setText(studentHobbies);

        confirm = findViewById(R.id.confirmBtn);
        back =findViewById(R.id.backBtn);

        confirmDialogueBuilder = new AlertDialog.Builder(this);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDialogueBuilder
                        .setTitle("Student Confirmation")
                        .setMessage("Are you really want to Confirmt?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "Succefully Registered!", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setIcon(R.drawable.warning_icon)
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
//                                finish();
                            }
                        });

                confirmDialogueBuilder.create().show();

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent stuendtRegiserIntent = new Intent(getApplicationContext(), StudentRegisterActivity.class);
                startActivity(stuendtRegiserIntent);
            }
        });



    }
}
