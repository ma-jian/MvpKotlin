package com.example.majian.mvpkotlin.di.module

import android.app.Application
import com.example.majian.mvpkotlin.http.CacheInterceptor
import com.example.majian.mvpkotlin.http.RequestInterceptor
import com.example.majian.mvpkotlin.utils.DataHelper
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by majian
 * Date : 2018/1/14
 * Describe : 网络请求基础依赖库
 */
@Module
open class ClientModule {
    private var TIME_OUT: Long = 10

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, builder: Retrofit.Builder, baseUrl: HttpUrl): Retrofit {
        return builder.baseUrl(baseUrl)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    @Singleton
    @Provides
    fun provideHttpClient(@Named("request")interceptor: Interceptor,@Named("cache")cacheInterceptor: Interceptor, builder: OkHttpClient.Builder,cache: Cache): OkHttpClient {
        return builder
                .addNetworkInterceptor(cacheInterceptor)
                .addInterceptor(interceptor)
                .addInterceptor(cacheInterceptor)
                .cache(cache)
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build()
    }

    @Singleton
    @Provides
    fun provideClientBuilder(): OkHttpClient.Builder {
        return OkHttpClient.Builder()
    }

    @Singleton
    @Provides
    fun provideRetrofitBuilder(): Retrofit.Builder {
        return Retrofit.Builder()
    }

    @Singleton
    @Provides
    @Named("request")
    fun provideInterceptor(interceptor: RequestInterceptor): Interceptor {
        return interceptor
    }

    @Singleton
    @Provides
    @Named("cache")
    fun provideCacheInterceptor(interceptor: CacheInterceptor): Interceptor {
        return interceptor
    }

    @Singleton
    @Provides
    fun cache(application: Application): Cache {
        return Cache(DataHelper.getDiskCacheDir(application,"demo"),50 * 1024 * 1024)
    }

    @Singleton
    @Provides
    fun provideHttpUrl(): HttpUrl {
        return HttpUrl.parse("https://api.github.com/")!!
    }
}