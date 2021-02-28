package com.sari.shopping.mvvmwithrettofit.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.sari.shopping.mvvmwithrettofit.database.MovieDao;
import com.sari.shopping.mvvmwithrettofit.database.MovieDatabase;
import com.sari.shopping.mvvmwithrettofit.model.Movie;
import com.sari.shopping.mvvmwithrettofit.model.PostModel;
import com.sari.shopping.mvvmwithrettofit.model.Repository.Repositoryi;

import java.util.List;

public class PostActivityViewModel extends AndroidViewModel {

    Repositoryi repository;
    MutableLiveData<List<PostModel>> list;

    public PostActivityViewModel(@NonNull Application application) {
        super(application);

        repository = new Repositoryi(getApplication());
        list = repository.getPostData();

    }

    public MutableLiveData<List<PostModel>> getListFromViewModel() {
        return list;
    }

}
