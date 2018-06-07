package com.example.majian.demo.di.component


import com.example.majian.demo.di.module.UserModule
import com.example.majian.demo.fragment.UserFragment
import com.example.majian.mvpkotlin.di.compoent.AppComponent
import com.example.majian.mvpkotlin.di.scope.FragmentScope

import dagger.Component

/**
 * Created by majian
 * Date : 2018/1/16
 * Describe :
 */
@FragmentScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(UserModule::class))
interface UserFragmentComPonent {
    fun inject(fragment: UserFragment)
}
