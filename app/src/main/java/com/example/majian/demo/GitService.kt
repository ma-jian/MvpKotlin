package com.example.majian.demo


import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by majian
 * Date : 2018/1/14
 * Describe :
 */
interface GitService {

    @GET("users/{user}")
    fun getUser(@Path("user") user: String): Observable<GithubUserCollection>
}