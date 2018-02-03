package com.example.majian.mvpkotlin.di.compoent

import android.app.Application
import com.example.majian.mvpkotlin.base.delegate.AppDelegate
import com.example.majian.mvpkotlin.di.module.AppModule
import com.example.majian.mvpkotlin.di.module.ClientModule
import com.example.majian.mvpkotlin.http.HttpManagerInterface
import com.google.gson.Gson
import dagger.Component
import okhttp3.OkHttpClient
import javax.inject.Singleton

/**
 * Created by majian
 * Date : 2018/1/14
 * Describe : 全局注解接口 ，网络框架基础依赖
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, ClientModule::class))
interface AppComponent {

    fun getApplication() : Application

    fun okhttpclient(): OkHttpClient

    fun gson(): Gson

    fun httpManager() : HttpManagerInterface

    fun inject(appDelegate: AppDelegate)

}