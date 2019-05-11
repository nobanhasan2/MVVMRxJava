package com.myres.noban.mvvmrxjava.data.remote

import com.myres.noban.mvvmrxjava.di.component.DaggerPostApiServiceComponent
import com.myres.noban.mvvmrxjava.model.Posts
import io.reactivex.Flowable

class GetPostFromRemoteServer {

    fun getPosts(): Flowable<List<Posts>>? {
        return DaggerPostApiServiceComponent.builder().build().getPostApiService().getAllPost()
    }
}

