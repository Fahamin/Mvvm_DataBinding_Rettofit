package com.sari.shopping.mvvmwithrettofit.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sari.shopping.mvvmwithrettofit.databinding.ItemlayoutBinding;
import com.sari.shopping.mvvmwithrettofit.databinding.ItempostLayoutBinding;
import com.sari.shopping.mvvmwithrettofit.model.PostModel;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostModelViewHolder> {

    List<PostModel> list;

    public PostAdapter(List<PostModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public PostModelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItempostLayoutBinding itempostLayoutBinding = ItempostLayoutBinding.inflate(inflater,parent,false);
        return new PostModelViewHolder(itempostLayoutBinding);

    }

    @Override
    public void onBindViewHolder(@NonNull PostModelViewHolder holder, int position) {

        PostModel PostModel =list.get(position);
        holder.bind(PostModel);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class PostModelViewHolder extends RecyclerView.ViewHolder {
        // If your layout file is something_awesome.xml then your binding class will be SomethingAwesomeBinding
        // Since our layout file is item_PostModel.xml, our auto generated binding class is ItemPostModelBinding

        private ItempostLayoutBinding binding;

        public PostModelViewHolder(ItempostLayoutBinding  binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(PostModel postModel)
        {
            binding.setModel(postModel);
            binding.executePendingBindings();
        }
    }
}
