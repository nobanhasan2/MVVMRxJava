package com.myres.noban.mvvmrxjava.di.module

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import okhttp3.OkHttpClient

import dagger.Module
import dagger.Provides

import javax.inject.Singleton

import com.myres.noban.mvvmrxjava.utils.Constant

@Module(
    includes = [
        OkHttpClientModule::class,
        GsonConverterFactoryModule::class
    ]
)
class RetrofitModule {

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, gsonConverterFactory: GsonConverterFactory): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(Constant.BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

}