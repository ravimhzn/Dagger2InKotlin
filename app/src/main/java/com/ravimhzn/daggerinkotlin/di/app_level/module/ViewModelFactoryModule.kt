package com.ravimhzn.daggerinkotlin.di.app_level.module

import androidx.lifecycle.ViewModelProvider
import com.ravimhzn.daggerinkotlin.di.app_level.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory
}