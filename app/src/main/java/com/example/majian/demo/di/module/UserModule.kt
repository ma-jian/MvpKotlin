package com.example.majian.demo.di.module

import com.example.majian.demo.Contract
import com.example.majian.mvpkotlin.di.scope.FragmentScope
import dagger.Module
import dagger.Provides

/**
 * Created by majian
 * Date : 2018/1/14
 * Describe :
 */
@Module
class UserModule(private var mView: Contract.mView) {

    @FragmentScope
    @Provides
    fun privadeView(): Contract.mView {
        return this.mView
    }
}