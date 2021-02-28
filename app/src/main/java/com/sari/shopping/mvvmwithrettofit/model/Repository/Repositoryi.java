package com.sari.shopping.mvvmwithrettofit.model.Repository;


import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.sari.shopping.mvvmwithrettofit.api.API;
import com.sari.shopping.mvvmwithrettofit.api.ApiUtils;
import com.sari.shopping.mvvmwithrettofit.database.MovieDao;
import com.sari.shopping.mvvmwithrettofit.database.MovieDatabase;
import com.sari.shopping.mvvmwithrettofit.model.Movie;
import com.sari.shopping.mvvmwithrettofit.model.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repositoryi {
    API api;
    private static Repositoryi repository;
    MutableLiveData<List<Movie>> data;
    MutableLiveData<List<PostModel>> postData;


    MovieDao dao;

    public Repositoryi(Application context) {
        if (repository != null) {
            repository = new Repositoryi(context);
        }
        data = new MutableLiveData<>();
        postData = new MutableLiveData<>();

        dao = MovieDatabase.getInstance(context).movieDao();

        api = ApiUtils.getAPIService();

    }


    public MutableLiveData<List<Movie>> getlistFromapi() {
        getList();
        return data;
    }

    public MutableLiveData<List<PostModel>> getPostData() {
        getpostList();
        return postData;
    }

    private void getpostList() {
        Call<List<PostModel>> call = api.getAllPost();

        call.enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                if(response.isSuccessful())
                {
                    postData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {

            }
        });
    }

    public void getList() {
        Call<List<Movie>> call = api.getAllList();

        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                if (response.isSuccessful()) {
                    data.postValue(response.body());

                    Log.i("ee", response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {

            }
        });
    }


}
