package com.myres.noban.mvvmrxjava.di.module

import android.content.Context
import android.util.Log

import java.io.File

import javax.inject.Named
import dagger.Module
import dagger.Provides

import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

import com.myres.noban.mvvmrxjava.utils.Constant.APPLICATION_SCOPE

@Module(
    includes = [
        ApplicationContextModule::class
    ]
)
class OkHttpClientModule {

    @Provides
    fun provideOkHttpClient(cache: Cache, loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient()
            .newBuilder()
            .cache(cache)
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    fun provideCache(cacheFile: File): Cache {
        return Cache(cacheFile, 10 * 1000 * 1000) //10 MB
    }

    @Provides
    fun provideFile(@Named(APPLICATION_SCOPE) context: Context): File {
        val file = File(context.cacheDir, "HttpCache")
        file.mkdirs()
        return file
    }

    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor(HttpLoggingInterceptor
            .Logger {
                Log.i("message", it)
            })
            .setLevel(HttpLoggingInterceptor.Level.BODY)
    }

}