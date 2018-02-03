package com.example.majian.mvpkotlin.base.lifecycle

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import com.example.majian.mvpkotlin.base.delegate.ActivityDelegateImpl
import com.example.majian.mvpkotlin.base.delegate.IActivity
import com.example.majian.mvpkotlin.utils.Preconditions
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by majian
 * Date : 2018/1/14
 * Describe :ActivityLifecycle 代理Activity 生命周期
 */
@Singleton
class ActivityLifecycle : Application.ActivityLifecycleCallbacks {
    private var activityDelegateb: ActivityDelegateImpl? = null
    private var fragmentLifecycle: FragmentLifecycle? = null

    @Inject
    constructor()

    override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
        if (activity is IActivity) {
            if (activityDelegateb == null) {
                activityDelegateb = ActivityDelegateImpl()
            }
            Preconditions.checkNotNull(activityDelegateb, "%s cannot be null , activityDelegateb必须实例化", activityDelegateb!!.javaClass.name)
            activityDelegateb?.onCreate(activity, savedInstanceState)
        }
        regiestFragmentLifecycle(activity)
    }

    private fun regiestFragmentLifecycle(activity: Activity?) {
        if (activity is FragmentActivity) {
            if (fragmentLifecycle == null) {
                fragmentLifecycle = FragmentLifecycle()
            }
            activity.supportFragmentManager.registerFragmentLifecycleCallbacks(fragmentLifecycle, true)
        }
    }

    override fun onActivityPaused(activity: Activity?) {
        if (activityDelegateb != null) {
            activityDelegateb!!.onPause()
        }
    }

    override fun onActivityResumed(activity: Activity?) {
        if (activityDelegateb != null) {
            activityDelegateb!!.onResume()
        }
    }

    override fun onActivityStarted(activity: Activity?) {
        if (activityDelegateb != null) {
            activityDelegateb!!.onStart()
        }
    }

    override fun onActivityDestroyed(activity: Activity?) {
        if (activityDelegateb != null) {
            activityDelegateb!!.onDestroy()
        }
    }

    override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {
        if (activityDelegateb != null) {
            activityDelegateb!!.onSaveInstanceState(activity!!, outState)
        }

    }

    override fun onActivityStopped(activity: Activity?) {
        if (activityDelegateb != null) {
            activityDelegateb!!.onStop()
        }
    }
}