package com.example.majian.mvpkotlin.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.majian.mvpkotlin.base.delegate.IFragment
import com.example.majian.mvpkotlin.base.lifecycle.RxFragmentLifecycle
import com.example.majian.mvpkotlin.mvp.IPresenter
import com.example.majian.mvpkotlin.mvp.IView
import com.trello.rxlifecycle2.android.FragmentEvent
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.Subject
import javax.inject.Inject

/**
 * Created by majian
 * Date : 2018/1/14
 * Describe :基类Fragment ，可拿到mPresenter实例
 */
abstract class BaseFragment<P : IPresenter> : Fragment(), RxFragmentLifecycle, IFragment,IView {
    var TAG: String = this.javaClass.name
    private var subject: BehaviorSubject<FragmentEvent> = BehaviorSubject.create()

    @JvmField
    @Inject
    var mPresenster: P? = null

    override fun provideSubject(): Subject<FragmentEvent> {
        return subject
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(initView(),container,false)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (mPresenster != null) {
            mPresenster!!.onDestory()
        }
        mPresenster = null
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }
}