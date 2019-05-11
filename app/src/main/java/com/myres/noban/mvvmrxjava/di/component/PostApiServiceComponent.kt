package com.myres.noban.mvvmrxjava.di.component

import com.myres.noban.mvvmrxjava.di.module.PostApiServiceModule
import com.myres.noban.mvvmrxjava.service.PostApiService

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        PostApiServiceModule::class
    ]
)
interface PostApiServiceComponent {
    fun getPostApiService(): PostApiService
}