package com.sari.shopping.mvvmwithrettofit.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.sari.shopping.mvvmwithrettofit.R;
import com.sari.shopping.mvvmwithrettofit.adapter.MovieAdapter;
import com.sari.shopping.mvvmwithrettofit.adapter.PostAdapter;
import com.sari.shopping.mvvmwithrettofit.database.MovieDao;
import com.sari.shopping.mvvmwithrettofit.database.MovieDatabase;
import com.sari.shopping.mvvmwithrettofit.database.PostDao;
import com.sari.shopping.mvvmwithrettofit.database.PostDatabase;
import com.sari.shopping.mvvmwithrettofit.model.Movie;
import com.sari.shopping.mvvmwithrettofit.model.PostModel;

import java.util.ArrayList;
import java.util.List;

public class OfflineDataShow extends AppCompatActivity {

    List<Movie> movies;
    List<PostModel> posts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offline_data_show);


        int i = getIntent().getIntExtra("k",1);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewID);
        recyclerView.setLayoutManager(new LinearLayoutManager(OfflineDataShow.this));


        if(i == 1)
        {
            MovieDao movieDao = MovieDatabase.getInstance(this).movieDao();
            movies = new ArrayList<>();
            movies = movieDao.getAllMovie();
            MovieAdapter adapter = new MovieAdapter(movies);
            recyclerView.setAdapter(adapter);
        }

        if(i == 2)
        {
            PostDao movieDao = PostDatabase.getInstance(this).postDao();
            posts = new ArrayList<>();
            posts = movieDao.getAllpost();
            PostAdapter adapter = new PostAdapter(posts);
            recyclerView.setAdapter(adapter);
        }




    }
}