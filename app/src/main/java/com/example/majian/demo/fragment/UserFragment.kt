package com.example.majian.demo.fragment

import android.os.Bundle
import com.example.majian.demo.Contract
import com.example.majian.demo.R
import com.example.majian.demo.UserFragmentPresenter
import com.example.majian.demo.di.DaggerUserFragmentPonent
import com.example.majian.demo.di.UserModule
import com.example.majian.mvpkotlin.base.BaseFragment
import com.example.majian.mvpkotlin.di.compoent.AppComponent
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by majian
 * Date : 2018/1/19
 * Describe :
 */
class UserFragment : BaseFragment<UserFragmentPresenter>(), Contract.mView {
    override fun initData(savedInstanceState: Bundle?) {
        button.setOnClickListener({
            mPresenster!!.getUser(editText.text.toString())
        })
    }

    override fun show(string: String) {
        text.text = string
    }

    override fun setAppComponent(appComponent: AppComponent) {
        DaggerUserFragmentPonent.builder().appComponent(appComponent)
                .userModule(UserModule(this))
                .build().inject(this)
    }

    override fun initView() = R.layout.activity_main
}