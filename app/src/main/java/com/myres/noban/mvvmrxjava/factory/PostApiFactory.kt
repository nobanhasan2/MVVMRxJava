package com.myres.noban.mvvmrxjava.factory

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import com.myres.noban.mvvmrxjava.utils.Constant.BASE_URL

object PostApiFactory {

//    private var retrofit: Retrofit? = null
//
//    private fun getRetrofit(): Retrofit? {
//        if (retrofit == null)
//            retrofit = Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//
//        return retrofit
//    }
//
//    fun <T> getPostApiService(serviceType: Class<T>): T? {
//        return getRetrofit()?.create(serviceType)
//    }
}