package com.ravimhzn.daggerinkotlin.ui.main.profile

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ravimhzn.daggerinkotlin.SessionManager
import com.ravimhzn.daggerinkotlin.models.User
import com.ravimhzn.daggerinkotlin.ui.auth.AuthResource
import javax.inject.Inject

class ProfileFragmentViewModel @Inject constructor(private val sessionManager: SessionManager) :
    ViewModel() {
    var TAG = ProfileFragmentViewModel::class.java.name
    init {
        Log.d(TAG, "ProfileFragmentViewModel is Ready to use....")
    }

    fun getAuthenticatedUser(): LiveData<AuthResource<User>> {
        return sessionManager.getAuthUser()
    }
}