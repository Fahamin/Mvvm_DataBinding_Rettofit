package com.sari.shopping.mvvmwithrettofit.database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.sari.shopping.mvvmwithrettofit.model.Movie;

@Database(entities = {Movie.class}, version = 1, exportSchema = false)
public abstract class MovieDatabase extends RoomDatabase {

    public abstract MovieDao movieDao();

    public static MovieDatabase instance;


    public static MovieDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), MovieDatabase.class,
                    "movieDatabase").allowMainThreadQueries().build();
        }

        return instance;
    }

    public static void destroyInstance() {
        instance = null;
    }
}
