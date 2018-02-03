package com.example.majian.mvpkotlin.base.delegate

import android.os.Bundle
import com.example.majian.mvpkotlin.di.compoent.AppComponent

/**
 * Created by majian
 * Date : 2018/1/14
 * Describe : Activity 基础接口， 使用Dagger2注解必须实现该接口
 */
interface IActivity {
    /**
     * 提供AppComponent实例
     */
    fun setAppComponent(appComponent: AppComponent)

    /**
     * 布局接口
     */
    fun initView(): Int

    /**
     * 数据接口
     */
    fun initData(savedInstanceState: Bundle?)

}