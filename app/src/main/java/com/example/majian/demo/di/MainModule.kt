package com.example.majian.demo.di

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
open class MainModule {

    private var mView: Contract.mView

    constructor(mView: Contract.mView) {
        this.mView = mView
    }

    @ActivityScope
    @Provides
    fun privadeView(): Contract.mView {
        return this.mView
    }

}


