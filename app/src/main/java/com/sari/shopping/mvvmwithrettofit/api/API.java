package com.sari.shopping.mvvmwithrettofit.api;


import com.sari.shopping.mvvmwithrettofit.model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {

    @GET("comments")
    Call<List<Movie>> getAllList();

}
