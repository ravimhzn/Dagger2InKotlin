package com.ravimhzn.daggerinkotlin.dummy;

import android.app.Application;

import com.ravimhzn.daggerinkotlin.ui.auth.AuthLoginActivity;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
public class DummyPractices {

    @Provides
    static String getAppInstance(Application application) {
        if (application != null) {
            return "Modafucker";
        }
        return "Test";
    }
}


@Module
abstract class ActivityBuildersModule {
    @ContributesAndroidInjector
    abstract AuthLoginActivity contributeAuthLoginActivity();

    @Provides
    static String someString() {
        return "This is a test";
    }
}
