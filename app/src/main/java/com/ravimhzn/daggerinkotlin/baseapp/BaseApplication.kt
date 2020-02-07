package com.ravimhzn.daggerinkotlin.baseapp

import com.ravimhzn.daggerinkotlin.di.components.AppComponent
import com.ravimhzn.daggerinkotlin.di.components.DaggerAppComponent
import dagger.android.support.DaggerApplication

class BaseApplication : DaggerApplication() {
//    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
//        return DaggerAppComponent.builder().application(this).build()
//    }
    override fun applicationInjector(): AppComponent? {
        return DaggerAppComponent.builder().application(this)?.build()
    }
}