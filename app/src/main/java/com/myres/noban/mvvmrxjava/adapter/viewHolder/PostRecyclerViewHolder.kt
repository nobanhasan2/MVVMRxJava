package com.myres.noban.mvvmrxjava.adapter.viewHolder

import androidx.recyclerview.widget.RecyclerView
import com.myres.noban.mvvmrxjava.databinding.ItemPostsBinding
import com.myres.noban.mvvmrxjava.model.Posts

class PostRecyclerViewHolder(
    private var bindView: ItemPostsBinding
) : RecyclerView.ViewHolder(bindView.root) {

    fun bind(item: Posts) {
        bindView.post = item
        bindView.executePendingBindings()
    }
}