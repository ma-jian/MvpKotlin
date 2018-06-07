package com.example.majian.demo.di.module

import com.example.majian.demo.Contract
import com.example.majian.mvpkotlin.di.scope.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * Created by majian
 * Date : 2018/1/14
 * Describe :
 */
@Module
class MainModule(private var mView: Contract.mView) {

    @ActivityScope
    @Provides
    fun privadeView(): Contract.mView {
        return mView
    }
}


