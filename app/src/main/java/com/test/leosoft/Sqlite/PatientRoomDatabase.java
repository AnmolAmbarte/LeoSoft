package com.test.leosoft.Sqlite;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.test.leosoft.model.Patient;


@Database(entities = {Patient.class}, version = 1)

public abstract class PatientRoomDatabase extends RoomDatabase {

    public abstract PatientDao siteDao();

    private static volatile PatientRoomDatabase siteRoomInstance;


    public static PatientRoomDatabase getDatabase(final Context context) {
        if (siteRoomInstance == null) {
            synchronized (PatientRoomDatabase.class) {
                if (siteRoomInstance == null) {
                    siteRoomInstance = Room.databaseBuilder(context.getApplicationContext(),
                            PatientRoomDatabase.class, "leo_database")
                            .build();
                }
            }
        }
        return siteRoomInstance;
    }

}
