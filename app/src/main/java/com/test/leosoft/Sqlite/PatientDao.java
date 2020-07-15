package com.test.leosoft.Sqlite;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.test.leosoft.model.Patient;

import java.util.List;

@Dao
public interface PatientDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPatientDetails(Patient patient);

    @Query("Select * from patients")
    LiveData<List<Patient>> getPatientsList();

}
