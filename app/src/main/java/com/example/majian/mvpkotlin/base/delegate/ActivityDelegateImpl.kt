package com.example.majian.mvpkotlin.base.delegate

import android.app.Activity
import android.os.Bundle
import com.example.majian.mvpkotlin.utils.Preconditions
import com.example.majian.mvpkotlin.utils.SystemUtil

/**
 * Created by majian
 * Date : 2018/1/14
 * Describe : Activity 生命周期代理实现类
 */
open class ActivityDelegateImpl : ActivityDelegate {
    private var IActivity: IActivity? = null
    private var activity: Activity? = null

    override fun onCreate(activity: Activity?, savedInstanceState: Bundle?) {
        Preconditions.checkNotNull(activity,"activity cannot be null; activity必须传入，否则无法使用注解 ")
        this.IActivity = activity as IActivity
        this.activity = activity
        if (IActivity != null) {
            IActivity!!.setAppComponent(SystemUtil.obtainAppComponentFromContext(activity))
        }
    }

    override fun onStart() {
    }

    override fun onResume() {
    }

    override fun onPause() {
    }

    override fun onStop() {
     }

    override fun onSaveInstanceState(activity: Activity?,outState: Bundle?) {
     }

    override fun onDestroy() {
        this.activity = null
        this.IActivity = null
    }

}