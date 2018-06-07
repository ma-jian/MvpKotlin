package com.example.majian.demo

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.OnLifecycleEvent
import com.example.majian.demo.di.HttpManager
import com.example.majian.mvpkotlin.di.scope.FragmentScope
import com.example.majian.mvpkotlin.http.RxThread
import com.example.majian.mvpkotlin.mvp.BasePresenter
import javax.inject.Inject

/**
 * Created by majian
 * Date : 2018/1/18
 * Describe :
 */
@FragmentScope
class UserFragmentPresenter @Inject constructor(userModule: HttpManager, view: Contract.mView) : BasePresenter<HttpManager, Contract.mView>(userModule, view) {
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    internal fun onCreate() {
        getUser("android")
    }

    fun getUser(string: String) {
        mModule!!.getUser(string)
                .compose(RxThread.applyAsync())
                .compose(RxThread.bindToLifecycle(mView!!))
                .subscribe(
                        { githubUserCollection ->
                            mView!!.show(githubUserCollection.toString())
                        },
                        { t ->
                            mView!!.show(t.message!!)
                        })
    }
}
