package com.example.majian.mvpkotlin.http

import android.content.Context

/**
 * Created by majian
 * Date : 2018/1/14
 * Describe : 网络管理接口
 */
interface HttpManagerInterface {

    fun <T>obtainRetrofitService(clazz: Class<T>): T

    fun getContext(): Context
}