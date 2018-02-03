package com.example.majian.mvpkotlin.base.delegate

import android.app.Activity
import android.os.Bundle

/**
 * Created by majian
 * Date : 2018/1/14
 * Describe : Activity 代理接口
 */
interface ActivityDelegate {

    fun onCreate(activity: Activity?, savedInstanceState: Bundle?)

    fun onStart()

    fun onResume()

    fun onPause()

    fun onStop()

    fun onSaveInstanceState(activity: Activity?, outState: Bundle?)

    fun onDestroy()
}