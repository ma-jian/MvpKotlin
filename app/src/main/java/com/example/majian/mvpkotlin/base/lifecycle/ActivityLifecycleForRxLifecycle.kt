package com.example.majian.mvpkotlin.base.lifecycle

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import com.example.majian.mvpkotlin.utils.Preconditions
import com.trello.rxlifecycle2.android.ActivityEvent
import io.reactivex.subjects.Subject
import javax.inject.Inject

/**
 * Created by majian
 * Date : 2018/1/14
 * Describe :ActivityLifecycleForRxLifecycle
 */
class ActivityLifecycleForRxLifecycle : Application.ActivityLifecycleCallbacks {
    @Inject
    constructor()

    private var fragmentLifecycle: FragmentManager.FragmentLifecycleCallbacks? = null

    override fun onActivityPaused(activity: Activity?) {
        if (activity is RxActivityLifecycle) {
            provideRxLifecycle(activity).onNext(ActivityEvent.PAUSE)
        }
    }

    override fun onActivityResumed(activity: Activity?) {
        if (activity is RxActivityLifecycle) {
            provideRxLifecycle(activity).onNext(ActivityEvent.RESUME)
        }
    }

    override fun onActivityStarted(activity: Activity?) {
        if (activity is RxActivityLifecycle) {
            provideRxLifecycle(activity).onNext(ActivityEvent.START)
        }
    }

    override fun onActivityDestroyed(activity: Activity?) {
        if (activity is RxActivityLifecycle) {
            provideRxLifecycle(activity).onNext(ActivityEvent.DESTROY)
        }
    }

    override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {
    }

    override fun onActivityStopped(activity: Activity?) {
        if (activity is RxActivityLifecycle) {
            provideRxLifecycle(activity).onNext(ActivityEvent.STOP)
        }
    }

    override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
        Preconditions.checkNotNull(activity, "%s cannot be null, activity 不可为null，否则lifecycle无法代理生命周", activity!!.javaClass.name)
        if (activity is RxActivityLifecycle) {
            provideRxLifecycle(activity).onNext(ActivityEvent.CREATE)
            if (activity is FragmentActivity) {
                if (fragmentLifecycle == null) {
                    fragmentLifecycle = FragmentLifecycleForRxLifecycle()
                }
                activity.supportFragmentManager.registerFragmentLifecycleCallbacks(fragmentLifecycle, true)
            }
        }
    }

    fun provideRxLifecycle(activity: Activity?): Subject<ActivityEvent> {
        Preconditions.checkNotNull(activity, "%s cannot be null", activity!!::class.java.name)
        return (activity as RxActivityLifecycle).provideSubject()
    }
}