package com.example.majian.mvpkotlin.http

import com.example.majian.mvpkotlin.utils.LogUtil
import okhttp3.Interceptor
import okhttp3.Response
import java.nio.charset.Charset
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by majian
 * Date : 2018/1/14
 * Describe : Logger 拦截器 添加公共头信息
 */
@Singleton
class RequestInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain?): Response {
        val request = chain!!.request()
        val hasRequestBody = request.body() != null
        //打印请求信息
        if (hasRequestBody) {
            val headers = request.headers()
            if (headers != null && headers.size() > 0) {
                for (i: Int in 0..headers.size()) {
                    LogUtil.d("header : " + headers.name(i) + ": " + headers.value(i))
                }
            }
        }
        val response = chain.proceed(request)
        val responseBody = response.body()
        val source = responseBody!!.source()
        source.request(java.lang.Long.MAX_VALUE) // Buffer the entire body.
        val buffer = source.buffer()
        val UTF8 = Charset.forName("UTF-8")
        LogUtil.json("Http " + request.method() + " url -> " + request.url().toString(), buffer.clone().readString(UTF8))
        return response

    }
}