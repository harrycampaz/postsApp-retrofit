package com.dezzapps.postsApp.holder;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dezzapps.paisesapp.R;
import com.dezzapps.postsApp.model.Post;
import com.dezzapps.postsApp.view.ViewPostActivity;

public class PostItemHolder extends RecyclerView.ViewHolder {

    TextView postTitle;
    TextView postBody;
    Context context;

    public PostItemHolder(@NonNull View itemView, Context context) {
        super(itemView);

        this.context = context;
        postTitle = itemView.findViewById(R.id.tv_title);
        postBody = itemView.findViewById(R.id.tv_body);

    }

    public  void bind(final Post post){

        postTitle.setText(post.getTitle());
        postBody.setText(post.getBody());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent  = new Intent(context, ViewPostActivity.class);
                intent.putExtra("postsId", post.getId());
                context.startActivity(intent);
            }
        });

    }
}
