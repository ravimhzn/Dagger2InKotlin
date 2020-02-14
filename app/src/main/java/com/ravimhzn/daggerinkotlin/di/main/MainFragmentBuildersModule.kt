package com.ravimhzn.daggerinkotlin.di.main

import com.ravimhzn.daggerinkotlin.ui.main.ProfileFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeProfileFragment(): ProfileFragment
}