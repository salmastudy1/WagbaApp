package com.example.wagba_salma.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;

import com.example.wagba_salma.Models.ProfileModel;

@Database(entities = {ProfileModel.class}, version = 1, exportSchema = false)
public abstract class myDatabase extends androidx.room.RoomDatabase {

    public abstract myProfileDao myProfileDao();

    private static myDatabase INSTANCE;

    public static myDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (myDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    myDatabase.class, "my_database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
