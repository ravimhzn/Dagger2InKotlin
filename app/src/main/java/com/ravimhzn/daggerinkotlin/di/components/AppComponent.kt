package com.ravimhzn.daggerinkotlin.di.components

import android.app.Application
import com.ravimhzn.daggerinkotlin.baseapp.BaseApplication
import com.ravimhzn.daggerinkotlin.di.module.ActivityBuildersModule
import com.ravimhzn.daggerinkotlin.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityBuildersModule::class,
        AppModule::class
    ]
)
interface AppComponent {
    //val sessionManager: SessionManager // must add here b/c injecting into abstract class

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: BaseApplication)
}

