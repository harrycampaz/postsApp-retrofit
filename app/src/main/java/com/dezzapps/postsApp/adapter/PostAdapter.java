package com.dezzapps.postsApp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dezzapps.paisesapp.R;
import com.dezzapps.postsApp.holder.PostItemHolder;
import com.dezzapps.postsApp.model.Post;

import java.util.List;

import retrofit2.http.POST;

public class PostAdapter extends RecyclerView.Adapter {

    private List<Post> postArrayList;


    public PostAdapter(List<Post> postArrayList) {
        this.postArrayList = postArrayList;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.post_item, parent, false);

        return new PostItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        PostItemHolder postItemHolder = (PostItemHolder) holder;
        postItemHolder.bind(postArrayList.get(position));

    }

    @Override
    public int getItemCount() {
        return postArrayList.size();
    }
}
