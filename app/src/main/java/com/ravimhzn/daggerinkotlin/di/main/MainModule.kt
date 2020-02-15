package com.ravimhzn.daggerinkotlin.di.main

import com.ravimhzn.daggerinkotlin.network.main.PostAPI
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class MainModule {
    @Provides
    fun providePostAPI(retrofit: Retrofit): PostAPI {
        return retrofit.create(PostAPI::class.java)
    }
}