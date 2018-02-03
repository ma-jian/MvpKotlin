package com.example.majian.mvpkotlin.di.module
import android.app.Application
import com.example.majian.mvpkotlin.http.HttpManagerImpl
import com.example.majian.mvpkotlin.http.HttpManagerInterface
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by majian
 * Date : 2018/1/14
 * Describe :基础依赖库
 */
@Module
open class AppModule {
    private var applicaiton: Application

    constructor(application: Application) {
        this.applicaiton = application
    }

    @Singleton
    @Provides
    fun provideApplication(): Application {
        return this.applicaiton
    }

    @Singleton
    @Provides
    fun provideGson(): Gson {
        var builder = GsonBuilder()
        return builder.create()
    }

    @Singleton
    @Provides
    fun provideHttpManager(httpManagerImpl: HttpManagerImpl): HttpManagerInterface {
        return httpManagerImpl
    }
}

