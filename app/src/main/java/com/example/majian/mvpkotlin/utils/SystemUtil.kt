package com.example.majian.mvpkotlin.utils
import android.content.Context
import com.example.majian.mvpkotlin.base.App
import com.example.majian.mvpkotlin.di.compoent.AppComponent

/**
 * Created by majian
 * Date : 2018/1/14
 * Describe :
 */
class SystemUtil {
    companion object {
        fun obtainAppComponentFromContext(context: Context?): AppComponent {
            Preconditions.checkNotNull(context, "%s cannot be null", Context::class.java.name)
            Preconditions.checkState(context?.applicationContext is App, "Application does not implements App")
            return (context?.applicationContext as App).getAppComponent()
        }
    }
}