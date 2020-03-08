package com.ravimhzn.daggerinkotlin.baseapp

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class BaseApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this)
    }

    //override fun activityInjector() = dispatchingAndroidInjector
    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }
}

/**
open class StarApplication : Application(), HasAndroidInjector {//} DaggerApplication(){

@Inject
lateinit var androidInjector: DispatchingAndroidInjector<Any>

override fun androidInjector(): AndroidInjector<Any> {
return androidInjector
}

override fun onCreate() {
super.onCreate()
setupAndroidThreeTen()
setupTimber()
AppInjector.init(this)
}

private fun setupTimber() {
if (BuildConfig.DEBUG) {
Timber.plant(Timber.DebugTree())
} else {
Timber.plant(CrashlyticsTree())
}
}

private fun setupAndroidThreeTen() {
AndroidThreeTen.init(this)
}
}**/