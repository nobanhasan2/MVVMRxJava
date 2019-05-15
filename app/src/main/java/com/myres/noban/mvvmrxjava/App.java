package com.myres.noban.mvvmrxjava;

import android.content.Context;
import android.net.ConnectivityManager;
import androidx.multidex.MultiDexApplication;
import org.jetbrains.annotations.Contract;

public class App extends MultiDexApplication {
    public static App instance;
    @Contract(pure = true)
    public static synchronized App getApp() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public boolean isNetworkAvailable() {
        final ConnectivityManager connectivityManager = ((ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }
}
