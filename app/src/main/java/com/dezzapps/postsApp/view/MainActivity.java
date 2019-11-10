package com.dezzapps.postsApp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.dezzapps.paisesapp.R;
import com.dezzapps.postsApp.adapter.PostAdapter;
import com.dezzapps.postsApp.model.Post;
import com.dezzapps.postsApp.services.GetPostsDataServices;
import com.dezzapps.postsApp.services.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private List<Post> posts;
    private static final String TAG = "MainActivity";

    private PostAdapter postAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // getPosts();
        setContentView(R.layout.activity_main);

        getPosts();
    }

    private void getPosts() {

        GetPostsDataServices getPostsDataServices = RetrofitInstance.getPostsDataServices();
        Call<List<Post>> call = getPostsDataServices.getPosts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if(!response.isSuccessful()){
                    System.out.println("Problemas al hacer el Request" + response.message());

                }else  {
                    posts = response.body();
                 /*   for(Post post: posts){
                        String content = "";
                        content += "userId" + post.getUserId() +"\n";
                        content += "title" + post.getTitle() +"\n";
                        content += "body" + post.getBody()+"\n\n";

                        Log.i(TAG, "onResponse: "+ content);

                    }*/
                    
                    loadView();
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });

    }

    private void loadView() {

        recyclerView =  findViewById(R.id.rv_posts);

        postAdapter = new PostAdapter(posts);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(postAdapter);


    }
}
