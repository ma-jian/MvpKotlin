package com.example.majian.mvpkotlin.base.lifecycle

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.View
import com.example.majian.mvpkotlin.base.delegate.FragmentDelegateImpl
import com.example.majian.mvpkotlin.base.delegate.IFragment
import com.example.majian.mvpkotlin.utils.Preconditions

/**
 * Created by majian
 * Date : 2018/1/14
 * Describe : 代理 UserFragment 生命周期
 */
class FragmentLifecycle : FragmentManager.FragmentLifecycleCallbacks() {
    private var fragmentDelegate: FragmentDelegateImpl? = null
    override fun onFragmentAttached(fm: FragmentManager?, f: Fragment?, context: Context?) {
        if (f is IFragment) {
            if (fragmentDelegate == null) {
                fragmentDelegate = FragmentDelegateImpl()
            }
            Preconditions.checkNotNull(f, "%s cannot be null", f.javaClass.name)
            Preconditions.checkNotNull(fm, "%s cannot be null", fm!!.javaClass.name)
            fragmentDelegate!!.onAttach(context, fm, f)
        }
    }

    override fun onFragmentCreated(fm: FragmentManager?, f: Fragment?, savedInstanceState: Bundle?) {
        if (fragmentDelegate != null) {
            fragmentDelegate!!.onCreate(savedInstanceState)
        }
    }

    override fun onFragmentViewCreated(fm: FragmentManager?, f: Fragment?, v: View?, savedInstanceState: Bundle?) {
        if (fragmentDelegate != null) {
            fragmentDelegate!!.onCreateView(v, savedInstanceState)
        }
    }

    override fun onFragmentActivityCreated(fm: FragmentManager?, f: Fragment?, savedInstanceState: Bundle?) {
        if (fragmentDelegate != null) {
            fragmentDelegate!!.onActivityCreate(savedInstanceState)
        }
    }

    override fun onFragmentStarted(fm: FragmentManager?, f: Fragment?) {
        if (fragmentDelegate != null) {
            fragmentDelegate!!.onStart()
        }
    }

    override fun onFragmentResumed(fm: FragmentManager?, f: Fragment?) {
        if (fragmentDelegate != null) {
            fragmentDelegate!!.onResume()
        }
    }

    override fun onFragmentPaused(fm: FragmentManager?, f: Fragment?) {
        if (fragmentDelegate != null) {
            fragmentDelegate!!.onPause()
        }
    }

    override fun onFragmentStopped(fm: FragmentManager?, f: Fragment?) {
        if (fragmentDelegate != null) {
            fragmentDelegate!!.onStop()
        }
    }

    override fun onFragmentSaveInstanceState(fm: FragmentManager?, f: Fragment?, outState: Bundle?) {
        if (fragmentDelegate != null) {
            fragmentDelegate!!.onSaveInstanceState(outState)
        }
    }

    override fun onFragmentViewDestroyed(fm: FragmentManager?, f: Fragment?) {
        if (fragmentDelegate != null) {
            fragmentDelegate!!.onDestroyView()
        }
    }

    override fun onFragmentDestroyed(fm: FragmentManager?, f: Fragment?) {
        if (fragmentDelegate != null) {
            fragmentDelegate!!.onDestroy()
        }
    }

    override fun onFragmentDetached(fm: FragmentManager?, f: Fragment?) {
        if (fragmentDelegate != null) {
            fragmentDelegate!!.onDetach()
        }
    }

}