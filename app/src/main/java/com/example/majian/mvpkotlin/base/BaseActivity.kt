package com.example.majian.mvpkotlin.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.majian.mvpkotlin.base.delegate.IActivity
import com.example.majian.mvpkotlin.base.lifecycle.RxActivityLifecycle
import com.example.majian.mvpkotlin.mvp.IPresenter
import com.example.majian.mvpkotlin.mvp.IView
import com.trello.rxlifecycle2.android.ActivityEvent
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.Subject
import javax.inject.Inject

/**
 * Created by majian
 * Date : 2018/1/14
 * Describe :Activity 基类，可拿到mPresenter 实例
 */

abstract class BaseActivity<P : IPresenter> : AppCompatActivity(), RxActivityLifecycle, IActivity,IView {
    var TAG: String = this.javaClass.name
    private var subject: BehaviorSubject<ActivityEvent> = BehaviorSubject.create()

    @JvmField
    @Inject
    internal var mPresenter: P? = null

    override fun provideSubject(): Subject<ActivityEvent> {
        return subject
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val layoutID = initView()
        if (layoutID != 0) {
            setContentView(layoutID)
        }
        initData(savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (mPresenter != null) {
            mPresenter!!.onDestory()
        }
        mPresenter = null
    }

    override fun hideLoading() {
    }

    override fun showLoading() {
    }
}