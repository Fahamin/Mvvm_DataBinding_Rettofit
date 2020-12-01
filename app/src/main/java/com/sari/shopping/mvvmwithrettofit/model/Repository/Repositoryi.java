package com.sari.shopping.mvvmwithrettofit.model.Repository;


import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.sari.shopping.mvvmwithrettofit.api.API;
import com.sari.shopping.mvvmwithrettofit.api.ApiUtils;
import com.sari.shopping.mvvmwithrettofit.model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repositoryi {
    API api;
    private static Repositoryi repository;
    MutableLiveData<List<Movie>> data;

    public Repositoryi() {
        if (repository != null) {
            repository = new Repositoryi();
        }
        data = new MutableLiveData<>();
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

                    Log.i("ee",response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {

            }
        });
    }
}
