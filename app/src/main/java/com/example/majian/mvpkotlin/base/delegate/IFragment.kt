package com.example.majian.mvpkotlin.base.delegate

import android.os.Bundle
import com.example.majian.mvpkotlin.di.compoent.AppComponent

/**
 * Created by majian
 * Date : 2018/1/14
 * Describe : Fragment基础接口，使用Dagger2必须实现
 */

interface IFragment {
    /**
     * 提供AppComponent实例
     */
    fun setAppComponent(appComponent: AppComponent)

    /**
     * 提供布局
     */
    fun initView():Int

    /**
     * 数据接口
     */
    fun initData(savedInstanceState: Bundle?)

}