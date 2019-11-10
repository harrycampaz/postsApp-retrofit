package com.dezzapps.postsApp.view;

import android.content.Intent;
import android.os.Bundle;

import com.dezzapps.postsApp.model.Post;
import com.dezzapps.postsApp.services.GetPostsDataServices;
import com.dezzapps.postsApp.services.RetrofitInstance;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.dezzapps.paisesapp.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewPostActivity extends AppCompatActivity {

    public static final  String POST_ID ="postsId";
    public int postId;
    public Post post;
    private static final String TAG = "ViewPostActivity";

    TextView title, body;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_post);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        title = findViewById(R.id.view_title);
        body = findViewById(R.id.view_body);

        Intent intent = getIntent();
        intent.hasExtra(POST_ID);
        if(intent.hasExtra(POST_ID)){
            setTitle("Ver Posts: #ID "+ intent.getIntExtra(POST_ID, 1));
            postId = intent.getIntExtra(POST_ID, 1);
            getOnePost(postId);
        } else {
            setTitle("No hay ID");
        }


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void getOnePost(int id){

        GetPostsDataServices getPostsDataServices = RetrofitInstance.getPostsDataServices();

        Call<Post> call = getPostsDataServices.getOnePosts(id);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                if(response.isSuccessful()){
                    post = response.body();
                    title.setText(post.getTitle());
                    body.setText(post.getBody());
                    Log.i(TAG, "onResponse: Mi Posts" + post.getId());
                }else {
                    Log.i(TAG, "onResponse: No se encontro los datos");
                }

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.i(TAG, "onFailure: Fallo el request");
            }
        });

    }

}
