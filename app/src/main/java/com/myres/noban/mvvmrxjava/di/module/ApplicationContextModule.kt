package com.myres.noban.mvvmrxjava.di.module

import android.content.Context

import com.myres.noban.mvvmrxjava.utils.Constant.APPLICATION_SCOPE

import dagger.Module
import dagger.Provides

import javax.inject.Named

@Module
class ApplicationContextModule(private val context: Context) {

    @Named(APPLICATION_SCOPE)
    @Provides
    fun context(): Context {
        return context.applicationContext
    }

}