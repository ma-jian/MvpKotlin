package com.example.majian.mvpkotlin.http

import android.app.Application
import android.content.Context
import com.example.majian.mvpkotlin.utils.Preconditions
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by majian
 * Date : 2018/1/14
 * Describe : 网络请求管理 提供Retrofit，不同Service数据访问
 */
@Singleton
class HttpManagerImpl @Inject constructor(retrofit: Retrofit, application: Application) : HttpManagerInterface {
    private var retrofit:Retrofit? = retrofit
    private var application: Application? = application

    /**
     * Service
     */
    override fun <T> obtainRetrofitService(clazz: Class<T>): T {
        Preconditions.checkNotNull(clazz, "%s cannot be null, the service class is must be", clazz.name)
        return retrofit!!.create(clazz)
    }

    override fun getContext(): Context {
        Preconditions.checkNotNull(application, "%s cannot be null", application?.packageName)
        return application!!
    }
}