package com.ravimhzn.daggerinkotlin.di.main

import com.ravimhzn.daggerinkotlin.ui.main.post.PostFragment
import com.ravimhzn.daggerinkotlin.ui.main.profile.ProfileFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeProfileFragment(): ProfileFragment

    @ContributesAndroidInjector
    abstract fun contributePostFragment(): PostFragment
}