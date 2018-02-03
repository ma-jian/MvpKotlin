package com.example.majian.mvpkotlin.base

import android.app.Application
import android.content.Context
import com.example.majian.mvpkotlin.base.delegate.AppDelegate
import com.example.majian.mvpkotlin.di.compoent.AppComponent
import com.example.majian.mvpkotlin.utils.Preconditions

/**
 * Created by majian
 * Date : 2018/1/14
 * Describe : Application基类
 */

class BaseApplication : Application(), App {
    private var appDelegate: AppDelegate? = null

    override fun getAppComponent(): AppComponent {
        Preconditions.checkNotNull(appDelegate, "%s cannot be null", appDelegate)
        Preconditions.checkNotNull(appDelegate as App,"%s your AppDelegate must extending app ",appDelegate?.javaClass?.name)
        return appDelegate!!.getAppComponent()
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        if (appDelegate == null) {
            this.appDelegate = AppDelegate()
        }
        appDelegate!!.attachBaseContext(base!!)
    }

    override fun onCreate() {
        super.onCreate()
        if (appDelegate != null) {
            appDelegate?.onCreate(this)
        }
    }

    override fun onTerminate() {
        super.onTerminate()
        if (appDelegate != null) {
            appDelegate?.onTerminate(this)
        }
    }

    override fun onLowMemory() {
        super.onLowMemory()
    }
}