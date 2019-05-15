package com.myres.noban.mvvmrxjava.utils

import android.content.Context
import android.net.ConnectivityManager

class NetManager(private var applicationContext: Context)  {

    val isConnectedToInternet: Boolean?
        get() {
            val manager = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            return manager.activeNetworkInfo != null && manager.activeNetworkInfo.isConnected
        }
}