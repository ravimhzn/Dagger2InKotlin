package com.ravimhzn.daggerinkotlin.network.main

import com.ravimhzn.daggerinkotlin.models.Posts
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface PostAPI {
    @GET("posts")
    fun getPost(@Query("userId") id: Int): Flowable<List<Posts>>
}