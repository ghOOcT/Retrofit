package com.example.asus.retrofit.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.item_post.view.*

class PostViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {

    val postTitle = itemView.itemTitle
    val postContent = itemView.itemContent
    val postAuthor = itemView.itemAuthor

}