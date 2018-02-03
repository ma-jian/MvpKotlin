package com.example.majian.mvpkotlin.base.delegate

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.View
import com.example.majian.mvpkotlin.utils.SystemUtil

/**
 * Created by majian
 * Date : 2018/1/14
 * Describe : Fragment 生命周期代理类
 */
class FragmentDelegateImpl : FragmentDelegate {

    private var fragmentManager: android.support.v4.app.FragmentManager? = null
    private var fragment: android.support.v4.app.Fragment? = null
    private var iFragment: IFragment? = null

    constructor()


    override fun onAttach(context: Context?, fm: FragmentManager?, f: Fragment?) {
        this.fragmentManager = fm
        this.fragment = f
        this.iFragment = f as IFragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        if (iFragment != null) {
            iFragment!!.setAppComponent(SystemUtil.obtainAppComponentFromContext(fragment!!.activity!!))
        }
    }

    override fun onCreateView(view: View?, savedInstanceState: Bundle?) {}

    override fun onActivityCreate(savedInstanceState: Bundle?) {}

    override fun onStart() {}

    override fun onResume() {}

    override fun onPause() {}

    override fun onStop() {}

    override fun onSaveInstanceState(outState: Bundle?) {}

    override fun onDestroyView() {}

    override fun onDestroy() {
        this.fragment = null
        this.fragmentManager = null
        this.iFragment = null
    }

    override fun onDetach() {}

}