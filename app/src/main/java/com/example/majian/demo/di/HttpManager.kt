package com.example.majian.demo.di

import com.example.majian.demo.GitService
import com.example.majian.demo.GithubUserCollection
import com.example.majian.mvpkotlin.http.HttpManagerInterface
import com.example.majian.mvpkotlin.mvp.BaseModule
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by majian
 * Date : 2018/1/18
 * Describe :
 */

class HttpManager @Inject constructor(httpManager: HttpManagerInterface) : BaseModule(httpManager) {
    fun getUser(name: String): Observable<GithubUserCollection> = httpManager!!.obtainRetrofitService(GitService::class.java).getUser(name)
}
