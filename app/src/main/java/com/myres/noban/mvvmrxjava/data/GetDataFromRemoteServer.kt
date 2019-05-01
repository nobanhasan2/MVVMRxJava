package com.myres.noban.mvvmrxjava.data

import com.myres.noban.mvvmrxjava.model.Posts
import io.reactivex.Flowable

class GetDataFromRemoteServer {

    fun getPosts(): Flowable<List<Posts>>? {
        return PostApiFactory.getPostApiService()?.getAllPost()
    }

}