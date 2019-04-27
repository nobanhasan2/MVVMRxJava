package com.myres.noban.mvvmrxjava.data

import com.myres.noban.mvvmrxjava.model.Posts
import io.reactivex.Flowable
import retrofit2.http.GET

interface ApiService {

    @GET("/posts")
    fun getPosts(): Flowable<List<Posts>>
}