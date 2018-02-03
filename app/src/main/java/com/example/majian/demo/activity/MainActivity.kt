package com.example.majian.demo.activity

import android.os.Bundle
import com.example.majian.demo.Contract
import com.example.majian.demo.GitService
import com.example.majian.demo.R
import com.example.majian.demo.di.DaggerComPonent
import com.example.majian.mvpkotlin.base.BaseActivity
import com.example.majian.mvpkotlin.base.BaseApplication
import com.example.majian.mvpkotlin.di.compoent.AppComponent
import com.example.majian.mvpkotlin.mvp.IPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by majian
 * Date : 2018/1/17
 * Describe :
 */

class MainActivity : BaseActivity<IPresenter>(), Contract.mView {
    override fun setAppComponent(appComponent: AppComponent) {
    }

    override fun initView(): Int = R.layout.activity_main

    override fun initData(savedInstanceState: Bundle?) {
        val application = application as BaseApplication
        DaggerComPonent.builder()
                .appComponent(application.getAppComponent())
                .build().inject(this)

        application.getAppComponent().httpManager()
                .obtainRetrofitService(GitService::class.java)
                .getUser("android")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { githubUserCollection -> text.text = githubUserCollection.toString() }
    }

    override fun show(string: String) {
    }
}
