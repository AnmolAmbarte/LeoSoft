package com.test.leosoft;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.test.leosoft.adapter.MainActivityAdapter;
import com.test.leosoft.model.Patient;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText patientName;
    EditText patientUHID;
    EditText patientAge;
    EditText patientDob;
    EditText patientAddress;
    EditText patientPhoneNumber;

    PatientViewModel patientViewModel;

    String[] gender = {"Male", "Female", "Other"};
    Patient patient = new Patient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        patientViewModel = new PatientViewModel(MainActivity.this);

        patientName = findViewById(R.id.p_name);
        patientUHID = findViewById(R.id.p_uhid);
        patientAge = findViewById(R.id.p_age);
        patientDob = findViewById(R.id.p_dob);
        patientAddress = findViewById(R.id.p_address);
        patientPhoneNumber = findViewById(R.id.p_number);

        Spinner spin = (Spinner) findViewById(R.id.p_gender);
        spin.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, gender);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);

        Button submit = findViewById(R.id.p_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                patient.setName(patientName.getText().toString().trim());
                patient.setUhid(patientUHID.getText().toString().trim());
                patient.setAge(patientAge.getText().toString().trim());
                patient.setDob(patientDob.getText().toString().trim());
                patient.setAddress(patientAddress.getText().toString().trim());
                patient.setPhoneNumber(patientPhoneNumber.getText().toString().trim());
                patientViewModel.insert(patient);

                Intent intent = new Intent(MainActivity.this, ListPatient.class);
                MainActivity.this.startActivity(intent);

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(), gender[position], Toast.LENGTH_LONG).show();
        patient.setGender(gender[position]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}
