package com.myres.noban.mvvmrxjava.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.myres.noban.mvvmrxjava.databinding.ItemPostsBinding
import com.myres.noban.mvvmrxjava.model.Posts

class PostRecyclerViewAdapter() : RecyclerView.Adapter<PostRecyclerViewHolder>() {
    private var posts: ArrayList<Posts>? = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostRecyclerViewHolder {
        val view = ItemPostsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostRecyclerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return posts?.size ?: 0
    }

    override fun onBindViewHolder(holder: PostRecyclerViewHolder, position: Int) {
        holder.bind(posts?.get(position)!!)
    }
}