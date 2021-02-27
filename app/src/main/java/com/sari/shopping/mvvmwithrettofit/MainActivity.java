package com.sari.shopping.mvvmwithrettofit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.sari.shopping.mvvmwithrettofit.adapter.MovieAdapter;
import com.sari.shopping.mvvmwithrettofit.database.MovieDao;
import com.sari.shopping.mvvmwithrettofit.database.MovieDatabase;
import com.sari.shopping.mvvmwithrettofit.databinding.ActivityMainBinding;
import com.sari.shopping.mvvmwithrettofit.model.Movie;
import com.sari.shopping.mvvmwithrettofit.viewmodel.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    List<Movie> list;
    MainActivityViewModel viewModel;

    public MovieDatabase movieDatabase;
    public MovieDao movieDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);


        list = new ArrayList<>();
        movieDatabase = MovieDatabase.getInstance(this);
        movieDao = movieDatabase.movieDao();


        RecyclerView recyclerView = binding.recyclerViewID;
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        viewModel.getListFromViewModel().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {

                MovieAdapter adapter = new MovieAdapter(movies);
                recyclerView.setAdapter(adapter);

                movieDao.insert(movies);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.offlineid)
        {
            startActivity(new Intent(this,OfflineDataShow.class));
        }
        return super.onOptionsItemSelected(item);
    }
}