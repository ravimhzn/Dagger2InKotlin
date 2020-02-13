package com.ravimhzn.daggerinkotlin.ui.auth

/*
* package com.ravimhzn.daggerinkotlin.ui.auth

import androidx.lifecycle.*
import com.ravimhzn.daggerinkotlin.SessionManager
import com.ravimhzn.daggerinkotlin.models.User
import com.ravimhzn.daggerinkotlin.network.AuthLoginAPI
import com.ravimhzn.daggerinkotlin.ui.auth.AuthResource.Error
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class AuthLoginViewModel @Inject constructor(authLoginAPI: AuthLoginAPI, sessionManager: SessionManager) : ViewModel() {

    private val TAG: String = "AuthLoginViewModel::"

    private var authLoginAPI: AuthLoginAPI = authLoginAPI

    private var sessionManager: SessionManager = sessionManager

    private var authUser = MediatorLiveData<AuthResource<User>>()

    /**
     * Get User Information from Server using RxJava and
     * Use ViewModel - LiveData to communicate with UI
     */


    fun observeUser(): LiveData<AuthResource<User>> {
        return authUser
    }


}


*
* */

//fun authenticateWithUserId(userId: Int) {
//    authUser.value = AuthResource.Loading(User())
//    var source = LiveDataReactiveStreams.fromPublisher(
//        authLoginAPI.getUser(userId)
//            .onErrorReturn {
//                val errorUser = User()
//                errorUser.id = -1
//                errorUser
//            }
//            .map { user ->
//                if (user.id == -1) {
//                    Error("Could not authenticate", null)
//                } else AuthResource.Success(user)
//            }
//            .subscribeOn(Schedulers.io())
//    )
//
//    //Converting the source to MediatorLiveData with AuthResource in between
//    authUser.addSource(source, Observer { t ->
//        authUser.value = t as AuthResource<User>?
//        authUser.removeSource(source)
//    })
//}