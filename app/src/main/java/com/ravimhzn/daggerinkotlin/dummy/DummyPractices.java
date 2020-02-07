package com.ravimhzn.daggerinkotlin.dummy;

import com.ravimhzn.daggerinkotlin.ui.activity.AuthLoginActivity;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

public class DummyPractices {
}


@Module
abstract class ActivityBuildersModule {
    @ContributesAndroidInjector
    abstract AuthLoginActivity contributeAuthLoginActivity();

    @Provides
    static String someString(){
        return "This is a test";
    }
}
