package com.myres.noban.mvvmrxjava.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.myres.noban.mvvmrxjava.databinding.ItemPostsBinding
import com.myres.noban.mvvmrxjava.model.Posts


class RecyklerViewAdapter() : RecyclerView.Adapter<RecyklerViewHolder>(){
    private var items:ArrayList<Posts>? = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyklerViewHolder {
      val view = ItemPostsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RecyklerViewHolder(view)
    }

    override fun getItemCount(): Int {
     return items?.size ?:0;
    }

    override fun onBindViewHolder(holder: RecyklerViewHolder, position: Int) {
        holder.bind(items?.get(position)!!)
    }
}