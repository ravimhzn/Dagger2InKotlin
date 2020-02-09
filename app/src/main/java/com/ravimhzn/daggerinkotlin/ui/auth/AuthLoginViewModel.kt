package com.ravimhzn.daggerinkotlin.ui.auth

import android.util.Log
import androidx.lifecycle.ViewModel
import com.ravimhzn.daggerinkotlin.models.User
import com.ravimhzn.daggerinkotlin.network.AuthLoginAPI
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AuthLoginViewModel @Inject constructor(authLoginAPI: AuthLoginAPI) : ViewModel() {

    private val TAG : String = "AuthLoginViewModel::"
    init {
        authLoginAPI.getUser(5)
            .toObservable()
            .subscribeOn(Schedulers.io())
            .subscribe(object : Observer<User> {
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {

                }

                override fun onNext(t: User) {
                    Log.d(TAG, "EMAIL :: ${t.email}")
                }

                override fun onError(e: Throwable) {
                    Log.d(TAG, "ERROR OCCURRED :: $e")
                }
            })

//        authLoginAPI.getUser(1)
//            .toObservable() // extension function for Iterables
//            .subscribeBy(  // named arguments for lambda Subscribers
//                onNext = { println(it) },
//                onError =  { it.printStackTrace() },
//                onComplete = { println("Done!") }
//            )

    }
}

