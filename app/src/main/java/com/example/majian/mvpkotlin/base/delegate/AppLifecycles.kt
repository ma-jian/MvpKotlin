package com.example.majian.mvpkotlin.base.delegate

import android.app.Application
import android.content.Context

/**
 * Created by majian
 * Date : 2018/1/14
 * Describe : application 生命周期代理接口
 */
interface AppLifecycles {

    fun attachBaseContext(base: Context)

    fun onCreate(application: Application)

    fun onTerminate(application: Application)
}