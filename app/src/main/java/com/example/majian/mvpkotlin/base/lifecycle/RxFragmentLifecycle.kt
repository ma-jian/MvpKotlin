package com.example.majian.mvpkotlin.base.lifecycle

import com.trello.rxlifecycle2.android.FragmentEvent

/**
 * Created by majian
 * Date : 2018/1/14
 * Describe :Fragment RxLifeCycle 接口
 */
interface RxFragmentLifecycle : Lifecycleable<FragmentEvent> {
}