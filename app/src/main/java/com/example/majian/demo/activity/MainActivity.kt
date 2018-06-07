package com.example.majian.demo.activity

import android.os.Bundle
import com.example.majian.demo.Contract
import com.example.majian.demo.GitService
import com.example.majian.demo.R
import com.example.majian.demo.MainPresenter
import com.example.majian.demo.di.component.DaggerMainComPonent
import com.example.majian.demo.di.module.MainModule
import com.example.majian.mvpkotlin.base.BaseActivity
import com.example.majian.mvpkotlin.di.compoent.AppComponent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by majian
 * Date : 2018/1/17
 * Describe :
 */

class MainActivity : BaseActivity<MainPresenter>(), Contract.mView {
    private lateinit var appComponent: AppComponent
    override fun setAppComponent(appComponent: AppComponent) {
        this.appComponent = appComponent
        DaggerMainComPonent.builder()
                .appComponent(appComponent)
                .mainModule(MainModule(this))
                .build()
                .inject(this)
    }

    override fun initView(): Int = R.layout.activity_main

    override fun initData(savedInstanceState: Bundle?) {
       appComponent.httpManager()
                .obtainRetrofitService(GitService::class.java)
                .getUser("android")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { githubUserCollection -> text.text = githubUserCollection.toString() }
    }

    override fun show(string: String) {}
}
