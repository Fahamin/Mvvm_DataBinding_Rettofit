package com.sari.shopping.mvvmwithrettofit.database;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.sari.shopping.mvvmwithrettofit.model.Movie;

import java.util.List;

@Dao
public interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert(List<Movie> movielist);

    @Query("Select * From Movie")
    public List<Movie> getAllMovie();
}
