package com.test.leosoft.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.test.leosoft.R;

public class MainActivityViewHolder extends RecyclerView.ViewHolder {

    TextView patientName;
    TextView patientUHID;
    TextView patientAge;
    TextView patientAdress;

    public MainActivityViewHolder(@NonNull View itemView) {
        super(itemView);

        patientName = itemView.findViewById(R.id.li_p_name);
        patientUHID = itemView.findViewById(R.id.li_p_uhid);
        patientAge = itemView.findViewById(R.id.li_p_age);
        patientAdress = itemView.findViewById(R.id.li_p_address);
    }
}
