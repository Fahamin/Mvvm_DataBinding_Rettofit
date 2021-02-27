package com.sari.shopping.mvvmwithrettofit.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.sari.shopping.mvvmwithrettofit.database.MovieDao;
import com.sari.shopping.mvvmwithrettofit.database.MovieDatabase;
import com.sari.shopping.mvvmwithrettofit.model.Movie;
import com.sari.shopping.mvvmwithrettofit.model.Repository.Repositoryi;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    MovieDatabase movieDatabase;
    MovieDao movieDao;
    Repositoryi repository;
    MutableLiveData<List<Movie>> list;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);

        repository = new Repositoryi(getApplication());
        list = repository.getlistFromapi();

    }

    public MutableLiveData<List<Movie>> getListFromViewModel() {
        return list;
    }

}
