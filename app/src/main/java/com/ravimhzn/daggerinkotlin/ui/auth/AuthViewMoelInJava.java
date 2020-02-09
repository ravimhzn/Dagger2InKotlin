package com.ravimhzn.daggerinkotlin.ui.auth;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.ravimhzn.daggerinkotlin.di.auth.AuthModule;
import com.ravimhzn.daggerinkotlin.models.User;
import com.ravimhzn.daggerinkotlin.network.AuthLoginAPI;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class AuthViewMoelInJava extends ViewModel {

//    public AuthViewMoelInJava(AuthLoginAPI authLoginAPI) {
//        authLoginAPI.getUser(1)
//                .toObservable()
//                .subscribeOn(Schedulers.io)
//                .subscribe(new Observer<User>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(User user) {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
//    }
}
