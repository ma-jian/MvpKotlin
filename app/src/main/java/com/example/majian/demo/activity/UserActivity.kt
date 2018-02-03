package com.example.majian.demo.activity

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import com.example.majian.demo.Contract
import com.example.majian.demo.R
import com.example.majian.demo.UserPresenter
import com.example.majian.demo.di.DaggerUserComponent
import com.example.majian.demo.di.MainModule
import com.example.majian.mvpkotlin.base.BaseActivity
import com.example.majian.mvpkotlin.di.compoent.AppComponent
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by majian
 * Date : 2018/1/17
 * Describe :
 */
class UserActivity : BaseActivity<UserPresenter>(), Contract.mView {
//    @Inject lateinit var module: mUserModule
//    @Inject lateinit var presenter: mPresenter

    //    @Inject lateinit var http:HttpManagerImpl
    override fun show(string: String) {
        text.text = string
    }

    override fun setAppComponent(appComponent: AppComponent) {
        val userComponent = DaggerUserComponent.builder()
                .appComponent(appComponent)
                .mainModule(MainModule(this))
                .build()
        userComponent.inject(this)
    }

    override fun initView(): Int = R.layout.activity_main

    override fun initData(savedInstanceState: Bundle?) {
//        LogUtil.d(TAG + " = " + presenter.toString())
        button.setOnClickListener({
            if (!TextUtils.isEmpty(editText.text.toString())) {
                mPresenter!!.getUser(editText.text.toString())
            }
        })

        button2.setOnClickListener({
            startActivity(Intent(this, FragmentActivity::class.java))
        })
    }
}