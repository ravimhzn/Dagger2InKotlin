package com.ravimhzn.daggerinkotlin

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.ravimhzn.daggerinkotlin.models.User
import com.ravimhzn.daggerinkotlin.ui.auth.AuthResource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SessionManager @Inject constructor() {

    private var TAG = SessionManager::class.java.name
    var cachedUser = MediatorLiveData<AuthResource<User>>()

    fun authenticateWithUserIdFromSessionManager(source: LiveData<AuthResource<User>>) {
        Log.d(TAG, "INSIDE SESSION MANAGER")
        cachedUser.value = AuthResource.Loading(null)
        cachedUser.addSource(source) {
            cachedUser.value = it as AuthResource<User>?
            cachedUser.removeSource(source)
        }
    }

    fun getAuthUser(): LiveData<AuthResource<User>> {
        return cachedUser
    }

    fun logout() {
        cachedUser.value = AuthResource.Logout()
    }
}