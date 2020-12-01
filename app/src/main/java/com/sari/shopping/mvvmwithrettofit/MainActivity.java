package com.sari.shopping.mvvmwithrettofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.sari.shopping.mvvmwithrettofit.adapter.MovieAdapter;
import com.sari.shopping.mvvmwithrettofit.databinding.ActivityMainBinding;
import com.sari.shopping.mvvmwithrettofit.model.Movie;
import com.sari.shopping.mvvmwithrettofit.viewmodel.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    List<Movie> list;
    MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        list = new ArrayList<>();
        RecyclerView recyclerView = binding.recyclerViewID;
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        viewModel.getListFromViewModel().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {

                MovieAdapter adapter = new MovieAdapter(movies);
                recyclerView.setAdapter(adapter);
            }
        });


    }
}