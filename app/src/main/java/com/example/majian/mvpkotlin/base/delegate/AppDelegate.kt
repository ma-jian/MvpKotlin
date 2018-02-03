package com.example.majian.mvpkotlin.base.delegate

import android.app.Application
import android.content.Context
import com.example.majian.mvpkotlin.base.App
import com.example.majian.mvpkotlin.base.lifecycle.ActivityLifecycle
import com.example.majian.mvpkotlin.base.lifecycle.ActivityLifecycleForRxLifecycle
import com.example.majian.mvpkotlin.di.compoent.AppComponent
import com.example.majian.mvpkotlin.di.compoent.DaggerAppComponent
import com.example.majian.mvpkotlin.di.module.AppModule
import com.example.majian.mvpkotlin.di.module.ClientModule
import com.example.majian.mvpkotlin.utils.Preconditions
import javax.inject.Inject

/**
 * Created by majian
 * Date : 2018/1/14
 * Describe : Application生命周期代理
 */

class AppDelegate : App, AppLifecycles {

    @JvmField
    @Inject
    var mActivityLifecycle: ActivityLifecycle? = null
    @JvmField
    @Inject
    var mActivityLifecycleForRxLifecycle: ActivityLifecycleForRxLifecycle? = null

    private lateinit var mApplication: Application
    private var appCompoent: AppComponent? = null


    constructor() {}

    /**
     *
     */
    override fun attachBaseContext(base: Context) {}

    override fun onCreate(application: Application) {
        this.mApplication = application
        appCompoent = DaggerAppComponent.builder()
                .appModule(AppModule(application))
                .clientModule(ClientModule())
                .build()
        appCompoent!!.inject(this)
        application.registerActivityLifecycleCallbacks(mActivityLifecycle)
        application.registerActivityLifecycleCallbacks(mActivityLifecycleForRxLifecycle)
    }

    override fun onTerminate(application: Application) {
        if (mActivityLifecycle != null) {
            mApplication.unregisterActivityLifecycleCallbacks(mActivityLifecycle)
        }
        if (mActivityLifecycleForRxLifecycle != null) {
            mApplication.unregisterActivityLifecycleCallbacks(mActivityLifecycleForRxLifecycle)
        }
        mActivityLifecycle = null
        mActivityLifecycleForRxLifecycle = null
        this.appCompoent = null
    }

    override fun getAppComponent(): AppComponent {
        Preconditions.checkNotNull(appCompoent,"%s cannot be null; AppComponent未被实例化" , appCompoent)
        return appCompoent!!
    }

}