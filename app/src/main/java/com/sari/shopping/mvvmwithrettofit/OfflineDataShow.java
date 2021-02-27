package com.sari.shopping.mvvmwithrettofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.RoomDatabase;

import android.os.Bundle;

import com.sari.shopping.mvvmwithrettofit.adapter.MovieAdapter;
import com.sari.shopping.mvvmwithrettofit.database.MovieDao;
import com.sari.shopping.mvvmwithrettofit.database.MovieDatabase;
import com.sari.shopping.mvvmwithrettofit.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class OfflineDataShow extends AppCompatActivity {

    List<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offline_data_show);

        MovieDao movieDao = MovieDatabase.getInstance(this).movieDao();

        movies = new ArrayList<>();
        movies = movieDao.getAllMovie();

        RecyclerView recyclerView = findViewById(R.id.recyclerViewID);

        recyclerView.setLayoutManager(new LinearLayoutManager(OfflineDataShow.this));

        MovieAdapter adapter = new MovieAdapter(movies);
        recyclerView.setAdapter(adapter);
    }
}