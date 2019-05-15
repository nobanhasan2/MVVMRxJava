package com.myres.noban.mvvmrxjava.di.module

import android.content.Context

import com.myres.noban.mvvmrxjava.utils.Constant.ACTIVITY_SCOPE

import dagger.Module
import dagger.Provides

import javax.inject.Named

@Module
class ActivityContextModule(private val context: Context) {

    @Named(ACTIVITY_SCOPE)
    @Provides
    fun provideContext(): Context {
        return context
    }

}