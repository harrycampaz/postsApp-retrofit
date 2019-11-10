package com.dezzapps.postsApp.services;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

import com.dezzapps.postsApp.model.Post;

import java.util.List;

public class PostsDiffCallback extends DiffUtil.Callback {

    List<Post> oldPostList;
    List<Post> newPostsList;

    public PostsDiffCallback(List<Post> oldPostList, List<Post> newPostsList) {
        this.oldPostList = oldPostList;
        this.newPostsList = newPostsList;
    }

    @Override
    public int getOldListSize() {
        return this.oldPostList == null ? 0:  oldPostList.size();
    }

    @Override
    public int getNewListSize() {
        return this.newPostsList == null ? 0:  newPostsList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldPostList.get(oldItemPosition).getId() == newPostsList.get(newItemPosition).getId();

    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldPostList.get(oldItemPosition).equals(oldPostList.get(newItemPosition).getId());
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }

}
