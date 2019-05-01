package com.myres.noban.mvvmrxjava.data

import com.myres.noban.mvvmrxjava.model.Posts
import io.reactivex.Flowable
import retrofit2.http.GET

interface PostApiService {

    @GET("/posts")
    fun getAllPost(): Flowable<List<Posts>>

}