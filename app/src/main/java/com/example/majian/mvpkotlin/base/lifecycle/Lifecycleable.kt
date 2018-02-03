package com.example.majian.mvpkotlin.base.lifecycle
import io.reactivex.subjects.Subject

/**
 * Created by majian
 * Date : 2018/1/14
 * Describe :提供LifeCycle被观察者接口
 */
interface Lifecycleable<T> {
    fun provideSubject(): Subject<T>
}