package com.example.majian.mvpkotlin.base.delegate

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.View

/**
 * Created by majian
 * Date : 2018/1/14
 * Describe : Fragment 生命周期代理接口
 */
interface FragmentDelegate {

    fun onAttach(context: Context?, fm: FragmentManager?, f: Fragment?)

    fun onCreate(savedInstanceState: Bundle?)

    fun onCreateView(view: View?, savedInstanceState: Bundle?)

    fun onActivityCreate(savedInstanceState: Bundle?)

    fun onStart()

    fun onResume()

    fun onPause()

    fun onStop()

    fun onSaveInstanceState(outState: Bundle?)

    fun onDestroyView()

    fun onDestroy()

    fun onDetach()
}