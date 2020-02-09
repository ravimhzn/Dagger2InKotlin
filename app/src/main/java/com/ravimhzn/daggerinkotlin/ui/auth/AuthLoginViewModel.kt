package com.ravimhzn.daggerinkotlin.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.ravimhzn.daggerinkotlin.models.User
import com.ravimhzn.daggerinkotlin.network.AuthLoginAPI
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AuthLoginViewModel @Inject constructor(authLoginAPI: AuthLoginAPI) : ViewModel() {

    private val TAG: String = "AuthLoginViewModel::"
    private lateinit var authLoginAPI: AuthLoginAPI

    private var authUser = MediatorLiveData<User>()

    init {
        this.authLoginAPI = authLoginAPI
    }

    /**
     * Get User Information from Server using RxJava and
     * Use ViewModel - LiveData to communicate with UI
     */
    fun authenticateWithMediatorLiveDataId(userId: Int) {
        var source = LiveDataReactiveStreams.fromPublisher(
            authLoginAPI.getUser(userId)
                .subscribeOn(Schedulers.io())
        )

        //Converting the source to MediatorLiveData
        authUser.addSource(source) {
            authUser.value = it
            authUser.removeSource(source)
        }
    }

    fun observeUser(): LiveData<User> {
        return authUser
    }


//    fun testHttpConnectionWithRetrofit() {
//        authLoginAPI.getUser(5)
//            .toObservable()
//            .subscribeOn(Schedulers.io())
//            .subscribe(object : Observer<User> {
//                override fun onComplete() {
//
//                }
//
//                override fun onSubscribe(d: Disposable) {
//
//                }
//
//                override fun onNext(t: User) {
//                    Log.d(TAG, "EMAIL :: ${t.email}")
//                }
//
//                override fun onError(e: Throwable) {
//                    Log.d(TAG, "ERROR OCCURRED :: $e")
//                }
//            })
//    }


    /**
     * Workaround without the use of MediatorLiveData
     */
    fun authenticateWithId(userId: Int): LiveData<User> {
        return LiveDataReactiveStreams.fromPublisher(
            authLoginAPI.getUser(userId).subscribeOn(
                Schedulers.io()
            )
        )
    }
}

