package com.myres.noban.mvvmrxjava.data.remote

import android.content.Context
import com.myres.noban.mvvmrxjava.di.component.DaggerPostApiServiceComponent
import com.myres.noban.mvvmrxjava.di.module.ApplicationContextModule
import com.myres.noban.mvvmrxjava.model.Posts
import io.reactivex.Flowable

class GetPostFromRemoteServer {


    fun getPosts(context:Context): Flowable<List<Posts>>? {
        return DaggerPostApiServiceComponent.builder().applicationContextModule(ApplicationContextModule(context)).build().getPostApiService().getAllPost()
    }
}

