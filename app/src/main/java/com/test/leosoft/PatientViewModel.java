package com.test.leosoft;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.test.leosoft.Sqlite.PatientDao;
import com.test.leosoft.Sqlite.PatientRoomDatabase;
import com.test.leosoft.model.Patient;

import java.util.List;

public class PatientViewModel {


    private PatientRoomDatabase patientRoomDatabase;
    private PatientDao patientDao;
    LiveData<List<Patient>> patientListLiveData;

    public PatientViewModel(Context mContext) {
        patientRoomDatabase = PatientRoomDatabase.getDatabase(mContext);
        patientDao = patientRoomDatabase.siteDao();
        patientListLiveData = patientDao.getPatientsList();
    }

    public LiveData<List<Patient>> getSites() {
        return patientListLiveData;
    }


    public void insert(Patient patient) {
        new InsertAsyncTask(patientDao).execute(patient);
    }


    private class InsertAsyncTask extends AsyncTask<Patient, Void, Void> {
        PatientDao mPatientDao;

        public InsertAsyncTask(PatientDao mSiteDao) {
            this.mPatientDao = mSiteDao;
        }

        @Override
        protected Void doInBackground(Patient... patients) {

            synchronized (this) {
                mPatientDao.insertPatientDetails(patients[0]);
                System.out.println("I was here to insert");
                return null;
            }

        }
    }

}
