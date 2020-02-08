package com.ravimhzn.daggerinkotlin.di.app_level.module

import com.ravimhzn.daggerinkotlin.di.auth.AuthLoginActivityViewModelModule
import com.ravimhzn.daggerinkotlin.ui.auth.AuthLoginActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(modules = [AuthLoginActivityViewModelModule::class])
    abstract fun contributeMainActivity(): AuthLoginActivity
}
