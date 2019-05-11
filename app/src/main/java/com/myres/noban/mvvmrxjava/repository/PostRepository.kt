package com.myres.noban.mvvmrxjava.repository

import android.content.Context
import com.myres.noban.mvvmrxjava.data.remote.GetPostFromRemoteServer
import com.myres.noban.mvvmrxjava.model.Posts
import com.myres.noban.mvvmrxjava.utils.NetManager
import io.reactivex.Flowable

class PostRepository(context: Context) {

    private val netManager = NetManager(context)
    private val remoteData = GetPostFromRemoteServer()

    fun getRepositories(): Flowable<List<Posts>>? {
        var posts : Flowable<List<Posts>>? = null

        netManager.isConnectedToInternet?.let { isConnectedToInternet ->
            if (isConnectedToInternet) {
                posts = remoteData.getPosts()!!
            } else {
                // ... Retrieve post from Room or cache
            }
        }

        return posts
    }
}