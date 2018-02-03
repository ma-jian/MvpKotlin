package com.example.majian.mvpkotlin.http

import android.annotation.SuppressLint
import com.example.majian.mvpkotlin.base.lifecycle.Lifecycleable
import com.example.majian.mvpkotlin.base.lifecycle.RxActivityLifecycle
import com.example.majian.mvpkotlin.base.lifecycle.RxFragmentLifecycle
import com.example.majian.mvpkotlin.mvp.IView
import com.trello.rxlifecycle2.LifecycleTransformer
import com.trello.rxlifecycle2.android.RxLifecycleAndroid
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by majian
 * Date : 2018/1/18
 * Describe :Rx相关
 */
class RxThread {
    companion object {
        /**
         * Rx 线程转换
         */
        fun <T> applyAsync(): ObservableTransformer<T, T> {
            return ObservableTransformer {
                it.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
            }
        }

        fun <T> bindToLifecycle(view: IView): LifecycleTransformer<T> {
            return if (view is Lifecycleable<*>) {
                bindToLifecycle<T>(view as Lifecycleable<*>)
            } else {
                throw IllegalArgumentException("view isn't Lifecycleable")
            }
        }

        @SuppressLint("CheckResult")
        fun <T> bindToLifecycle(lifecycleable: Lifecycleable<*>): LifecycleTransformer<T> {
            return if (lifecycleable is RxActivityLifecycle) {
                RxLifecycleAndroid.bindActivity(lifecycleable.provideSubject())
            } else if (lifecycleable is RxFragmentLifecycle) {
                RxLifecycleAndroid.bindFragment(lifecycleable.provideSubject())
            } else {
                throw IllegalArgumentException("Lifecycleable not match")
            }
        }
    }
}