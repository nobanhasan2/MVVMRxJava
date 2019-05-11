package com.myres.noban.mvvmrxjava.service

import com.myres.noban.mvvmrxjava.model.Posts
import io.reactivex.Flowable
import retrofit2.http.GET

interface PostApiService {

    @GET("/posts")
    fun getAllPost(): Flowable<List<Posts>>

}