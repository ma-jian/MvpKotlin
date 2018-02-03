package com.example.majian.mvpkotlin.base.lifecycle

import com.trello.rxlifecycle2.android.ActivityEvent

/**
 * Created by majian
 * Date : 2018/1/14
 * Describe :Activity RxLifeCycle 接口
 */
interface RxActivityLifecycle : Lifecycleable<ActivityEvent> {
}