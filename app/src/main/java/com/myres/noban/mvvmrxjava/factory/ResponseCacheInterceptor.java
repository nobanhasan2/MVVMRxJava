package com.myres.noban.mvvmrxjava.factory;

/**
 * Created by Rafiqul Hasan Rony on 2/3/19.
 * Audacity It Solution.
 */

import androidx.annotation.NonNull;

import com.myres.noban.mvvmrxjava.App;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * Interceptor to cache data and maintain it for a minute.
 * <p>
 * If the same network request is sent within a minute,
 * the response is retrieved from cache.
 */

public class ResponseCacheInterceptor implements Interceptor {
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request request = chain.request();
        if (Boolean.valueOf(request.header("ApplyResponseCache"))) {
            Response originalResponse = chain.proceed(request);
            return originalResponse.newBuilder()
                    .removeHeader("ApplyResponseCache")
                    .header("Cache-Control", App.getApp().isNetworkAvailable() ? "public, max-age=" + 60 : "public, only-if-cached, max-stale=" + 2419200)
                    .build();
        } else {
            return chain.proceed(request);
        }
    }
}
