package com.myres.noban.mvvmrxjava.di.module

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import com.myres.noban.mvvmrxjava.service.PostApiService

@Module(
    includes = [
        RetrofitModule::class
    ]
)
class PostApiServiceModule {

    @Provides
    fun providePostApiService(retrofit: Retrofit): PostApiService {
        return retrofit.create(PostApiService::class.java)
    }

}