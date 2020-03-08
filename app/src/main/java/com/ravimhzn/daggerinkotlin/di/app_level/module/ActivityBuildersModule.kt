package com.ravimhzn.daggerinkotlin.di.app_level.module

import com.ravimhzn.daggerinkotlin.di.auth.AuthLoginViewModelModule
import com.ravimhzn.daggerinkotlin.di.auth.AuthModule
import com.ravimhzn.daggerinkotlin.di.main.MainFragmentBuildersModule
import com.ravimhzn.daggerinkotlin.di.main.MainModule
import com.ravimhzn.daggerinkotlin.di.main.MainViewModelModule
import com.ravimhzn.daggerinkotlin.ui.auth.AuthLoginActivity
import com.ravimhzn.daggerinkotlin.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
        modules = [AuthLoginViewModelModule::class,
            AuthModule::class]
    )
    abstract fun contributeAuthActivity(): AuthLoginActivity

    @ContributesAndroidInjector(
        modules = [
            MainFragmentBuildersModule::class,
            MainViewModelModule::class,
            MainModule::class
        ]
    )
    abstract fun contributeMainActivity(): MainActivity
}
