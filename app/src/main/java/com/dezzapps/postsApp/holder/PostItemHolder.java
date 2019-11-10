package com.dezzapps.postsApp.holder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dezzapps.paisesapp.R;
import com.dezzapps.postsApp.model.Post;

public class PostItemHolder extends RecyclerView.ViewHolder {

    TextView postTitle;
    TextView postBody;

    public PostItemHolder(@NonNull View itemView) {
        super(itemView);

        postTitle = itemView.findViewById(R.id.tv_title);
        postBody = itemView.findViewById(R.id.tv_body);

    }

    public  void bind(final Post post){

        postTitle.setText(post.getTitle());
        postBody.setText(post.getBody());

    }
}
