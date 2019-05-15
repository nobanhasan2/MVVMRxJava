package com.myres.noban.mvvmrxjava.di.module

import android.content.Context
import android.util.Log
import com.franmontiel.persistentcookiejar.PersistentCookieJar
import com.franmontiel.persistentcookiejar.cache.SetCookieCache
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor
import com.myres.noban.mvvmrxjava.App
import com.myres.noban.mvvmrxjava.factory.OfflineResponseCacheInterceptor
import com.myres.noban.mvvmrxjava.factory.ResponseCacheInterceptor

import java.io.File

import javax.inject.Named
import dagger.Module
import dagger.Provides

import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

import com.myres.noban.mvvmrxjava.utils.Constant.APPLICATION_SCOPE
import java.net.CookieManager
import java.net.CookiePolicy
import java.util.concurrent.TimeUnit

@Module(
    includes = [
        ApplicationContextModule::class
    ]
)
class OkHttpClientModule {


    @Provides
    fun provideOkHttpClient(cache: Cache, loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
         var okHttpClient: OkHttpClient? =null
        if (okHttpClient == null) {
            val okHttpClientBuilder = OkHttpClient.Builder()
            okHttpClientBuilder.connectTimeout(30, TimeUnit.SECONDS)
            okHttpClientBuilder.readTimeout(30, TimeUnit.SECONDS)
            okHttpClientBuilder.writeTimeout(30, TimeUnit.SECONDS)

            okHttpClientBuilder.cache(cache)
            val cookieManager = CookieManager()
            cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL)
            okHttpClientBuilder.cookieJar(PersistentCookieJar(SetCookieCache(), SharedPrefsCookiePersistor(App.getApp().applicationContext)))

            okHttpClientBuilder.addNetworkInterceptor(ResponseCacheInterceptor())
            okHttpClientBuilder.addInterceptor(OfflineResponseCacheInterceptor())

            okHttpClientBuilder.addInterceptor { chain -> chain.proceed(chain.request().newBuilder().build()) }
            okHttpClientBuilder.addInterceptor(loggingInterceptor)

            okHttpClient = okHttpClientBuilder.build()
        }

        return okHttpClient!!
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