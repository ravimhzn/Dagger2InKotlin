package com.ravimhzn.daggerinkotlin.di.auth

import androidx.lifecycle.ViewModel
import com.ravimhzn.daggerinkotlin.di.app_level.ViewModelKey
import com.ravimhzn.daggerinkotlin.ui.auth.AuthLoginActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AuthLoginActivityViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthLoginActivityViewModel::class)
    abstract fun bindAuthViewModel(authViewModel: AuthLoginActivityViewModel): ViewModel
}