package com.myres.noban.mvvmrxjava.service

import com.myres.noban.mvvmrxjava.model.Posts
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Headers

interface PostApiService {

    @Headers("ApplyOfflineCache: true", "ApplyResponseCache: true")
    @GET("/posts")
    fun getAllPost(): Flowable<List<Posts>>

}