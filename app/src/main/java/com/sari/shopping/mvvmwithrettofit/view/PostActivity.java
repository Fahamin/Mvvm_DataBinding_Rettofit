package com.sari.shopping.mvvmwithrettofit.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.sari.shopping.mvvmwithrettofit.R;
import com.sari.shopping.mvvmwithrettofit.adapter.PostAdapter;

import com.sari.shopping.mvvmwithrettofit.database.PostDao;
import com.sari.shopping.mvvmwithrettofit.database.PostDatabase;
import com.sari.shopping.mvvmwithrettofit.databinding.ActivityPostBinding;
import com.sari.shopping.mvvmwithrettofit.model.PostModel;
import com.sari.shopping.mvvmwithrettofit.viewmodel.PostActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class PostActivity extends AppCompatActivity {

    ActivityPostBinding binding;
    PostActivityViewModel viewModel;


    public PostDatabase postDatabase;
    public PostDao postDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding = DataBindingUtil.setContentView(this, R.layout.activity_post);

       viewModel = ViewModelProviders.of(this).get(PostActivityViewModel.class);


        postDatabase = PostDatabase.getInstance(this);
        postDao = postDatabase.postDao();

        RecyclerView recyclerView = binding.recyclerViewID;

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        viewModel.getListFromViewModel().observe(this, new Observer<List<PostModel>>() {
            @Override
            public void onChanged(List<PostModel> postModels) {

                PostAdapter adapter = new PostAdapter(postModels);
                recyclerView.setAdapter(adapter);
                postDao.insert_post(postModels);

            }
        });

    }
}