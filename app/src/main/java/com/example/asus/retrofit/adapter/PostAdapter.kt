package com.example.asus.retrofit.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.asus.retrofit.R
import com.example.asus.retrofit.model.Post

class PostAdapter(internal val context: Context, internal  val postList: List<Post>): RecyclerView.Adapter<PostViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_post,parent,false)
        return PostViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.postTitle.text = postList[position].title.toString()
        holder.postContent.text = StringBuilder(postList[position].body.substring(0,20)).append("...").toString()
        holder.postAuthor.text = postList[position].userId.toString()
    }

}