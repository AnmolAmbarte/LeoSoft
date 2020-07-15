package com.test.leosoft.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.test.leosoft.R;
import com.test.leosoft.model.Patient;

import java.util.ArrayList;
import java.util.List;

public class MainActivityAdapter extends RecyclerView.Adapter<MainActivityViewHolder> {

    Context mContext;
    List<Patient> mDetails = new ArrayList<Patient>();

    public MainActivityAdapter(Context context, List<Patient> data) {
        this.mContext = context;
        this.mDetails = data;
        setHasStableIds(true);
    }

    @NonNull
    @Override
    public MainActivityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.patient_list_item_layout, parent, false);
        MainActivityViewHolder myViewHolder = new MainActivityViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainActivityViewHolder holder, int position) {
        holder.patientName.setText(mDetails.get(position).getName());
        holder.patientUHID.setText(mDetails.get(position).getUhid());
        holder.patientAge.setText(mDetails.get(position).getAge());
        holder.patientAdress.setText(mDetails.get(position).getAddress());
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        if (mDetails != null)
            return mDetails.size();
        else
            return 0;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

}
