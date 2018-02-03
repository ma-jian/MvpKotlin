package com.example.majian.mvpkotlin.mvp


/**
 * Created by majian
 * Date : 2018/1/14
 * Describe : View 接口;  供View层接口继承
 */
interface IView {

    fun showLoading()

    fun hideLoading()

    fun showToast(msg:String)
}