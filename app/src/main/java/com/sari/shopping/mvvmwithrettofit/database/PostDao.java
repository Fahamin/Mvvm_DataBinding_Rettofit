package com.sari.shopping.mvvmwithrettofit.database;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.sari.shopping.mvvmwithrettofit.model.Movie;
import com.sari.shopping.mvvmwithrettofit.model.PostModel;

import java.util.List;

@Dao
public interface PostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert_post(List<PostModel> postlist);

    @Query("Select * From PostModel")
    public List<PostModel> getAllpost();

}
