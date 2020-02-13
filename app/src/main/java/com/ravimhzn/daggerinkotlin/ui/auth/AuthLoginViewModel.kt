package com.ravimhzn.daggerinkotlin.ui.auth

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.ravimhzn.daggerinkotlin.SessionManager
import com.ravimhzn.daggerinkotlin.models.User
import com.ravimhzn.daggerinkotlin.network.AuthLoginAPI
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class AuthLoginViewModel @Inject constructor(
    private val authLoginAPI: AuthLoginAPI,
    private val sessionManager: SessionManager
) : ViewModel() {

    private val TAG: String = AuthLoginViewModel::class.java.name

    fun authenticateWithUserId(userId: Int) {
        Log.d(TAG, "****ATTEMPTING TO LOGIN***")
        sessionManager.authenticateWithUserIdFromSessionManager(queryUserId(userId))
    }

    fun observeAuthUser(): LiveData<AuthResource<User>> {
        return sessionManager.observeUser()
    }

    fun queryUserId(userID: Int): LiveData<AuthResource<User>> {
        return LiveDataReactiveStreams.fromPublisher(
            authLoginAPI.getUser(userID)
                .onErrorReturn {
                    val user = User()
                    user.id = -1
                    user
                }
                .map(object : Function<User, AuthResource<User>> {
                    override fun apply(user: User): AuthResource<User> {
                        if (user.id == -1) {
                            //While using enums be sure to call it through the class. AuthResource.Error
                            return AuthResource.Error("Could not authenticated", null)
                        }
                        return AuthResource.Success(user)
                    }

                })
                .subscribeOn(Schedulers.io())
        )
    }
}

