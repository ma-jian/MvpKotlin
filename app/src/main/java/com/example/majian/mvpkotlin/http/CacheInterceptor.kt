package com.example.majian.mvpkotlin.http

import android.app.Application
import com.example.majian.mvpkotlin.utils.DeviceUtils
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by majian
 * Date : 2018/1/18
 * Describe : 缓存拦截器
 */
@Singleton
class CacheInterceptor @Inject constructor(private var application: Application) : Interceptor {

    override fun intercept(chain: Interceptor.Chain?): Response {
        var request = chain?.request()
        var response = chain?.proceed(request)
        if (DeviceUtils.isNetworkConnected(application)) {
            var maxAge = 60 * 60 * 24; // 有网络的时候从缓存1天后失效
            response!!.newBuilder()
                    .removeHeader("Pragma")
                    .header("Cache-Control", "public, max-age=" + maxAge)
                    .build();
        } else {
            var maxStale = 60 * 60 * 24 * 30 // // 无网络缓存30天
            response!!.newBuilder()
                    .removeHeader("Pragma")
                    .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                    .build();
        }
        return response
    }
}