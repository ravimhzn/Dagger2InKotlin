package com.ravimhzn.daggerinkotlin.di;

import android.app.Application;

import com.ravimhzn.daggerinkotlin.baseapp.BaseApplication;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Component(modules = {
        AndroidSupportInjectionModule.class
})
public interface AppComponentJava extends AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponentJava build();

    }
}
