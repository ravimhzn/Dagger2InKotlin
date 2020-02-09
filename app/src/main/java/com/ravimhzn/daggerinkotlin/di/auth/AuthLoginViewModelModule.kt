package com.ravimhzn.daggerinkotlin.di.auth

import androidx.lifecycle.ViewModel
import com.ravimhzn.daggerinkotlin.di.app_level.ViewModelKey
import com.ravimhzn.daggerinkotlin.ui.auth.AuthLoginViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AuthLoginViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthLoginViewModel::class)
    abstract fun bindAuthViewModel(authViewModel: AuthLoginViewModel): ViewModel
}