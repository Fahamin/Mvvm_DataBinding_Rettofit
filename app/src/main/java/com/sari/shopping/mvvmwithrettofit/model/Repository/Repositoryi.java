package com.sari.shopping.mvvmwithrettofit.model.Repository;


import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.sari.shopping.mvvmwithrettofit.MainActivity;
import com.sari.shopping.mvvmwithrettofit.api.API;
import com.sari.shopping.mvvmwithrettofit.api.ApiUtils;
import com.sari.shopping.mvvmwithrettofit.database.MovieDao;
import com.sari.shopping.mvvmwithrettofit.database.MovieDatabase;
import com.sari.shopping.mvvmwithrettofit.model.Movie;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repositoryi {
    API api;
    private static Repositoryi repository;
    MutableLiveData<List<Movie>> data;

    List<Movie> list;
    MovieDao dao;

    public Repositoryi(Application context) {
        if (repository != null) {
            repository = new Repositoryi(context);
        }
        data = new MutableLiveData<>();
        dao = MovieDatabase.getInstance(context).movieDao();
        list = new ArrayList<>();
    }


    public MutableLiveData<List<Movie>> getlistFromapi() {
        getList();
        return data;
    }

    public void getList() {
        api = ApiUtils.getAPIService();
        Call<List<Movie>> call = api.getAllList();

        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                if (response.isSuccessful()) {
                    data.postValue(response.body());
                    list = response.body();

                    Log.i("ee", response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {

            }
        });
    }



}
