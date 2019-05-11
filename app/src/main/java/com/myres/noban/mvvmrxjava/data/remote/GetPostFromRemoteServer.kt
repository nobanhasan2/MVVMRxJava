package com.myres.noban.mvvmrxjava.data.remote

import com.myres.noban.mvvmrxjava.factory.PostApiFactory
import com.myres.noban.mvvmrxjava.model.Posts
import com.myres.noban.mvvmrxjava.service.PostApiService
import io.reactivex.Flowable

class GetPostFromRemoteServer {

    fun getPosts(): Flowable<List<Posts>>? {
        return PostApiFactory.getPostApiService(PostApiService::class.java)?.getAllPost()
    }

}