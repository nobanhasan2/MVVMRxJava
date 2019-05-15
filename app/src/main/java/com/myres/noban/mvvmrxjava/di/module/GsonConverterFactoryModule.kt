package com.myres.noban.mvvmrxjava.di.module

import retrofit2.converter.gson.GsonConverterFactory

import com.google.gson.Gson
import com.google.gson.GsonBuilder

import dagger.Provides
import dagger.Module

@Module
class GsonConverterFactoryModule {

    @Provides
    fun provideGsonConverterFactory(gson: Gson): GsonConverterFactory {
        return GsonConverterFactory.create(gson)
    }

    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

}