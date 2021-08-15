package com.ssp.studentapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashSet;

public class StudentRegisterActivity extends AppCompatActivity {
    CheckBox cricket, chess, carrom;
    EditText stName, stEmail, stPwd, stAADHAR,stFname, stMname;
    ToggleButton genderToggle;
    RadioGroup reservationRadioGroup;
    RadioButton selectedReservationRadioBtn;
    Button submitStudentRegisterBtn;
    Spinner studentClass;
    AlertDialog.Builder studnetSubmitDialog;
    HashSet<String> hobbies = new HashSet<>();
    String selectedGender = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_register_activity);
        cricket = findViewById(R.id.cricket);
        chess = findViewById(R.id.chess);
        carrom = findViewById(R.id.carrams);
        genderToggle = findViewById(R.id.studnetGender);
        reservationRadioGroup = findViewById(R.id.studnetReservation);
        submitStudentRegisterBtn = findViewById(R.id.studentRegBtn);
        studentClass = findViewById(R.id.studnetClassSpinner);
        stName = findViewById(R.id.studnetName);
        stFname = findViewById(R.id.studentFather);
        stMname = findViewById(R.id.studnetMother);
        stPwd = findViewById(R.id.studnetEmailPwd);
        stEmail = findViewById(R.id.studnetEmail);
        stAADHAR = findViewById(R.id.studnetAadhar);

        studnetSubmitDialog = new AlertDialog.Builder(this);

        //Listener creation
        cricket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Job of your listner
                if (cricket.isChecked()) {
                    Toast checkBoxToast = Toast.makeText(getApplicationContext(), "Your Hobby Is :" + cricket.getText(), Toast.LENGTH_SHORT);
                    checkBoxToast.show();
                    hobbies.add(cricket.getText().toString());
                }
                else {
                    hobbies.remove(cricket.getText().toString());
                }

            }
        });
        chess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Job of your listner
                if (chess.isChecked()) {
                    Toast checkBoxToast = Toast.makeText(getApplicationContext(), "Your Hobby Is :" + chess.getText(), Toast.LENGTH_SHORT);
                    checkBoxToast.show();
                    hobbies.add(chess.getText().toString());
                }
                else {
                    hobbies.remove(chess.getText().toString());
                }

            }
        });

        carrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Job of your listner
                if (carrom.isChecked()) {
                    Toast checkBoxToast = Toast.makeText(getApplicationContext(), "Your Hobby Is :" + carrom.getText(), Toast.LENGTH_SHORT);
                    checkBoxToast.show();
                    hobbies.add(carrom.getText().toString());
                }
                else {
                    hobbies.remove(carrom.getText().toString());
                }

            }
        });



        //listener creation for gender
        genderToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (genderToggle.getText().equals("YES")) {
                    Toast taggleToast = Toast.makeText(getApplicationContext(), "Hi Sir!", Toast.LENGTH_SHORT);
                    taggleToast.show();
                    selectedGender="Male";

                } else {
                    Toast taggleToast = Toast.makeText(getApplicationContext(), "Hi MAM!", Toast.LENGTH_SHORT);
                    taggleToast.show();
                    selectedGender = "Female";
                }

            }
        });


        reservationRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                System.out.println("Entered into : reservationRadioGroup");
                int reservationId = reservationRadioGroup.getCheckedRadioButtonId();
                selectedReservationRadioBtn = findViewById(reservationId);
                Toast reservationToast = Toast.makeText(getApplicationContext(), "Your Reservation Is" + selectedReservationRadioBtn.getText(), Toast.LENGTH_LONG);
                reservationToast.show();

            }
        });

        studentClass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                studentClass.getSelectedItem().toString();
                Toast.makeText(getApplicationContext(), studentClass.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

      /**  studentClass.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                studentClass.getSelectedItem().toString();
                Toast.makeText(getApplicationContext(), studentClass.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();
            }
        });**/
        submitStudentRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(stName.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"You missed Name and its mandatory", Toast.LENGTH_SHORT).show();
                    stName.setHint("Name is required");
                    stName.setHintTextColor(Color.RED);
                    stName.setFocusable(true);
                }
                else
                {
                    Intent studentConfirmationIntent = new Intent(getApplicationContext(), StudentConfirrmationActivity.class);
                    studentConfirmationIntent.putExtra("StName", stName.getText().toString());
                    studentConfirmationIntent.putExtra("StFName", stFname.getText().toString());
                    studentConfirmationIntent.putExtra("StMName", stMname.getText().toString());
                    studentConfirmationIntent.putExtra("StEmail", stEmail.getText().toString());
                    studentConfirmationIntent.putExtra("StPwd", stPwd.getText().toString());
                    studentConfirmationIntent.putExtra("StAADHAR", stAADHAR.getText().toString());
                    studentConfirmationIntent.putExtra("StClass", studentClass.getSelectedItem().toString());
                    studentConfirmationIntent.putExtra("StGender", selectedGender);
                    studentConfirmationIntent.putExtra("StHobbies", hobbies.toString());
//                studentConfirmationIntent.putExtra("Reservation", selectedReservationRadioBtn.getText().toString());

                    startActivity(studentConfirmationIntent);
                }

            }
        });


    }
}
