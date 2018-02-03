package com.example.majian.mvpkotlin.mvp
import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.OnLifecycleEvent
import com.example.majian.mvpkotlin.http.HttpManagerInterface

/**
 * Created by majian
 * Date : 2018/1/14
 * Describe : Module 基类，提供HttpManager
 */
open class BaseModule : IModule, LifecycleObserver {
   protected var httpManager: HttpManagerInterface?=null
    constructor(httpManager: HttpManagerInterface) {
        this.httpManager = httpManager
    }

    override fun onDestory() {
        httpManager = null
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestory(lifecycleOwner: LifecycleOwner) {
        lifecycleOwner.lifecycle.removeObserver(this)
    }

}