package com.example.majian.mvpkotlin.http

/**
 * @Author m
 * @Date 2017/5/26
 * 自定义异常
 */

class ApiException : Exception {
    var code: Int = 0

    constructor(message: String) : super(message) {}

    constructor(code: Int, message: String) : super(message) {
        this.code = code
    }
}
