package com.example.majian.demo.di

import com.example.majian.demo.activity.UserActivity
import com.example.majian.mvpkotlin.di.compoent.AppComponent
import com.example.majian.mvpkotlin.di.scope.ActivityScope
import dagger.Component

/**
 * Created by majian
 * Date : 2018/1/17
 * Describe :
 */
@ActivityScope
@Component(modules = [MainModule::class],dependencies = [AppComponent::class])
interface UserComponent {
    fun inject (userActivity: UserActivity)
}