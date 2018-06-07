package com.example.majian.demo.activity

import android.os.Bundle
import com.example.majian.demo.Contract
import com.example.majian.demo.R
import com.example.majian.demo.fragment.UserFragment
import com.example.majian.mvpkotlin.base.BaseActivity
import com.example.majian.mvpkotlin.di.compoent.AppComponent
import com.example.majian.mvpkotlin.mvp.IPresenter

/**
 * Created by majian
 * Date : 2018/1/19
 * Describe :
 */
class FragmentActivity : BaseActivity<IPresenter>(), Contract.mView {

    override fun show(string: String) {}

    override fun setAppComponent(appComponent: AppComponent) {}

    override fun initView(): Int = R.layout.activity_fragment

    override fun initData(savedInstanceState: Bundle?) {
        supportFragmentManager.beginTransaction().replace(R.id.framelayout, UserFragment()).commit()
    }
}