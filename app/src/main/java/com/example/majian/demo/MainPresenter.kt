package com.example.majian.demo

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.OnLifecycleEvent
import com.example.majian.demo.di.HttpManager
import com.example.majian.mvpkotlin.di.scope.ActivityScope
import com.example.majian.mvpkotlin.http.RxThread
import com.example.majian.mvpkotlin.mvp.BasePresenter
import javax.inject.Inject

/**
 * Created by majian
 * Date : 2018/1/18
 * Describe :
 */
@ActivityScope
class MainPresenter @Inject constructor(userModule: HttpManager, view: Contract.mView) : BasePresenter<HttpManager, Contract.mView>(userModule,view) {
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    internal fun onCreate() {
        getUser("kotlin")
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
