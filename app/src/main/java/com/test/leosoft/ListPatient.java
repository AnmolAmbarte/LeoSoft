package com.test.leosoft;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.test.leosoft.adapter.MainActivityAdapter;
import com.test.leosoft.model.Patient;

import java.util.ArrayList;
import java.util.List;

public class ListPatient extends AppCompatActivity {


    private PatientViewModel patientViewModel;
    RecyclerView.Adapter mAdapter;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    Context context;
    private ProgressBar progressBar;


    List<Patient> mDetails = new ArrayList<Patient>();

    Button addPatient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_patient);
        progressBar = (ProgressBar) findViewById(R.id.progress_list);
        progressBar.setVisibility(View.VISIBLE);
        recyclerView = findViewById(R.id.list_recyclerView);
        initRecyclerView();
        addPatient = findViewById(R.id.add_patient);
        addPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListPatient.this, MainActivity.class);
                ListPatient.this.startActivity(intent);
            }
        });


        patientViewModel = new PatientViewModel(ListPatient.this);
        patientViewModel.getSites().observe(this, new Observer<List<Patient>>() {
            @Override
            public void onChanged(List<Patient> patients) {

                System.out.println("Details Size : " + patients.size());
                if (patients.size() > 0) {
                    System.out.println("Fill Data");
                    mDetails.addAll(patients);
                    mAdapter.notifyDataSetChanged();
                    progressBar.setVisibility(View.INVISIBLE);
                }
            }
        });

    }


    private void initRecyclerView() {
        if (mAdapter == null) {
            mAdapter = new MainActivityAdapter(ListPatient.this, mDetails);
            RecyclerView.LayoutManager manager = layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            recyclerView.setLayoutManager(manager);
            recyclerView.setAdapter(mAdapter);
        }
    }

}
