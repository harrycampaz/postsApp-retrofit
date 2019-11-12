package com.dezzapps.postsApp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.dezzapps.paisesapp.R;
import com.dezzapps.postsApp.model.Post;
import com.dezzapps.postsApp.services.GetPostsDataServices;
import com.dezzapps.postsApp.services.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddPostsActivity extends AppCompatActivity {

    private TextView editTitle;
    private TextView editBody;
    private Button buttonSend;

    private static final String TAG = "AddPostsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_posts);

        editTitle = findViewById(R.id.editText_title);
        editBody = findViewById(R.id.editText_body);

        buttonSend = findViewById(R.id.button_send);



        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editTitle.getText().length() > 0 && editBody.getText().length() > 0){

                    Post post = new  Post();

                    post.setTitle(editTitle.getText().toString());
                    post.setBody(editBody.getText().toString());

                    sendPosts(post);


                    Toast.makeText(getApplicationContext(), "Posts Enviado", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "Posts NO Enviado", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    private void sendPosts(Post post){


        GetPostsDataServices getPostsDataServices = RetrofitInstance.getPostsDataServices();

        Call<Post> call = getPostsDataServices.postsData(post);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                if(response.isSuccessful()){
                    Log.i(TAG, "onResponse: " +response.body().toString());
                }else {
                    Log.d(TAG, "onResponse: Problemas con el request");
                }

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

                Log.i(TAG, "onFailure: "+ t.getMessage());
            }
        });

    }
}
