package com.example.majian.demo

import com.example.majian.mvpkotlin.mvp.IView

/**
 * Created by majian
 * Date : 2018/1/15
 * Describe :
 */
interface Contract {

    interface mView : IView {
        fun show(string: String)
    }
}