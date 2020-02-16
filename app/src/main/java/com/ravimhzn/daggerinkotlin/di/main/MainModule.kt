package com.ravimhzn.daggerinkotlin.di.main

import com.ravimhzn.daggerinkotlin.network.main.PostAPI
import com.ravimhzn.daggerinkotlin.ui.main.post.PostRecyclerAdapter
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit


@Module
class MainModule {
    @Provides
    fun providePostAPI(retrofit: Retrofit): PostAPI {
        return retrofit.create(PostAPI::class.java)
    }

    @Provides
    fun provideAdapter(): PostRecyclerAdapter {
        return PostRecyclerAdapter()
    }
}