package com.sari.shopping.mvvmwithrettofit.database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.sari.shopping.mvvmwithrettofit.model.Movie;
import com.sari.shopping.mvvmwithrettofit.model.PostModel;


@Database(entities = {PostModel.class}, version = 2, exportSchema = false)
public abstract class PostDatabase extends RoomDatabase {

    public abstract PostDao postDao();
    public static PostDatabase instance;

    public static PostDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), PostDatabase.class,
                    "postDatabase").allowMainThreadQueries().build();
        }

        return instance;
    }

    public static void destroyInstance() {
        instance = null;
    }
}
