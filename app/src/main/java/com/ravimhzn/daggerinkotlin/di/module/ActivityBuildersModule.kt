package com.ravimhzn.daggerinkotlin.di.module

import com.ravimhzn.daggerinkotlin.ui.activity.AuthLoginActivity
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class ActivityBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeAuthLoginActivity(): AuthLoginActivity?

    companion object {
        @Provides
        fun someString(): String {
            return "Welcome to my awesome project"
        }
    }
}
