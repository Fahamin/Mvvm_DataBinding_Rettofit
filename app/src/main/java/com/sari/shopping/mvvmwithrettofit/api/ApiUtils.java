package com.sari.shopping.mvvmwithrettofit.api;

public class ApiUtils {
    private ApiUtils() {
    }

    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    public static API getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(API.class);
    }
}
