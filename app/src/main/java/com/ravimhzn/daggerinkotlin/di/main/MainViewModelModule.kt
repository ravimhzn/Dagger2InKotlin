package com.ravimhzn.daggerinkotlin.di.main

import androidx.lifecycle.ViewModel
import com.ravimhzn.daggerinkotlin.di.app_level.ViewModelKey
import com.ravimhzn.daggerinkotlin.ui.main.post.PostViewModel
import com.ravimhzn.daggerinkotlin.ui.main.profile.ProfileFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProfileFragmentViewModel::class)
    abstract fun bindProfileViewModel(profileFragmentViewModel: ProfileFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PostViewModel::class)
    abstract fun bindPostViewModel(postViewModel: PostViewModel): ViewModel
}