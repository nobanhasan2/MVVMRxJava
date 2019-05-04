package com.myres.noban.mvvmrxjava.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.myres.noban.mvvmrxjava.R
import com.myres.noban.mvvmrxjava.adapter.PostRecyclerViewAdapter
import com.myres.noban.mvvmrxjava.databinding.ActivityMainBinding
import com.myres.noban.mvvmrxjava.model.Posts
import com.myres.noban.mvvmrxjava.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    private val repositoryRecyclerViewAdapter = PostRecyclerViewAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainViewModel = ViewModelProviders.of(
            this
        ).get(MainViewModel::class.java)

        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main)

        binding.apply {
            viewModel = mainViewModel
            executePendingBindings()
            repositoryRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            repositoryRecyclerView.adapter = repositoryRecyclerViewAdapter
        }

        mainViewModel.posts.observe(this, Observer<List<Posts>> {
            it?.let { it ->
                repositoryRecyclerViewAdapter.replaceData(it as ArrayList<Posts>)
            }
        })

    }


}
