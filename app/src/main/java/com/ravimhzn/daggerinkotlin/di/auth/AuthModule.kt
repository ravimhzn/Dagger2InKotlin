package com.ravimhzn.daggerinkotlin.di.auth

import com.ravimhzn.daggerinkotlin.network.AuthLoginAPI
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class AuthModule {

    @Provides
    fun provideAuthLoginApi(retrofit: Retrofit): AuthLoginAPI {
        return retrofit.create(AuthLoginAPI::class.java)
    }
}