package com.dezzapps.postsApp.services;

import com.dezzapps.postsApp.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetPostsDataServices {

    @GET("posts")
    Call<List<Post>> getPosts();

}
