package com.ravimhzn.daggerinkotlin.network

import com.ravimhzn.daggerinkotlin.models.User
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path


interface AuthLoginAPI {

    @GET("users/{id}")
    fun getUser(@Path("id") id: Int): Flowable<User>
}