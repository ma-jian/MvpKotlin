package com.example.majian.mvpkotlin

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.widget.Toast

/**
 * Created by majian
 * Date : 2018/1/20
 * Describe :kotlin 扩展函数
 */

fun <T> Activity.newInstence(context: Context, clazz: Class<T>, bundle: Bundle? = null) {
    context.startActivity(Intent(context, clazz).putExtra("bundle", bundle))
}

fun Activity.ShowToast(context: Context, string: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(context, string, duration).show()
}

fun Fragment.ShowToast(context: Context, string: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(context, string, duration).show()
}