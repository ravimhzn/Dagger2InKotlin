package com.ravimhzn.daggerinkotlin.di.module

import com.ravimhzn.daggerinkotlin.ui.activity.AuthLoginActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): AuthLoginActivity
}
