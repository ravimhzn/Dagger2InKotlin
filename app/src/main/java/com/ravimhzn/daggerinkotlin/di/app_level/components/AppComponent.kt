package com.ravimhzn.daggerinkotlin.di.app_level.components

import android.app.Application
import com.ravimhzn.daggerinkotlin.baseapp.BaseApplication
import com.ravimhzn.daggerinkotlin.di.app_level.module.ActivityBuildersModule
import com.ravimhzn.daggerinkotlin.di.app_level.module.AppModule
import com.ravimhzn.daggerinkotlin.di.app_level.module.ViewModelFactoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityBuildersModule::class,
        AppModule::class,
        ViewModelFactoryModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: BaseApplication)
}

