
package com.example.majian.mvpkotlin.base

import com.example.majian.mvpkotlin.di.compoent.AppComponent

/**
 * Created by majian
 * Date : 2018/1/14
 * Describe : Applicaiont 接口 提供AppComponent实例
 */
interface App {
    fun getAppComponent() : AppComponent
}