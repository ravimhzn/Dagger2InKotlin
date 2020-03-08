package com.ravimhzn.daggerinkotlin.baseapp

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.ravimhzn.daggerinkotlin.di.app_level.components.DaggerAppComponent
import dagger.android.AndroidInjection

object AppInjector {
//    fun init(app: BaseApplication) {
//        DaggerAppComponent.builder().application(app).build().inject(app)
//
//        app.registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
//            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
//                handleActivity(activity)
//            }
//
//            override fun onActivityStarted(activity: Activity) {
//
//            }
//
//            override fun onActivityResumed(activity: Activity) {
//
//            }
//
//            override fun onActivityPaused(activity: Activity) {
//
//            }
//
//            override fun onActivityStopped(activity: Activity) {
//
//            }
//
//            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle?) {
//
//            }
//
//            override fun onActivityDestroyed(activity: Activity) {
//
//            }
//        })
//    }
//
//    private fun handleActivity(activity: Activity) {
//        if (activity is HasSupportFragmentInjector) {
//            AndroidInjection.inject(activity)
//        }
//        if (activity is FragmentActivity) {
//            activity.supportFragmentManager
//                .registerFragmentLifecycleCallbacks(
//                    object : FragmentManager.FragmentLifecycleCallbacks() {
//                        override fun onFragmentCreated(
//                            fm: FragmentManager,
//                            f: Fragment,
//                            savedInstanceState: Bundle?
//                        ) {
//                            if (f is Injectable) {
//                                AndroidSupportInjection.inject(f)
//                            }
//                        }
//                    }, true
//                )
//        }
//    }

    fun init(app: BaseApplication) {
        DaggerAppComponent
            .builder()
            .application(app)
            .build()
            .inject(app)


        app.registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
            override fun onActivityPaused(activity: Activity?) {
            }

            override fun onActivityResumed(activity: Activity?) {
            }

            override fun onActivityStarted(activity: Activity?) {
            }

            override fun onActivityDestroyed(activity: Activity?) {
            }

            override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {
            }

            override fun onActivityStopped(activity: Activity?) {
            }

            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                handleActivity(activity)
            }

        })
    }

    private fun handleActivity(activity: Activity) {
        if (activity is Injectable) {
            AndroidInjection.inject(activity)
        }

    }
}