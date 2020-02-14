package com.ravimhzn.daggerinkotlin

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.lifecycle.Observer
import com.ravimhzn.daggerinkotlin.models.User
import com.ravimhzn.daggerinkotlin.ui.auth.AuthLoginActivity
import com.ravimhzn.daggerinkotlin.ui.auth.AuthResource
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject


open class BaseActivity : DaggerAppCompatActivity() {

    private var TAG = BaseActivity::class.java.name
    /**
     * Handles the user session in our app
     */
    @Inject
    lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        subscribeObservers()
    }

    //Subscribe to the observer SessionManager.
    // That way it will be listening for any changes made on SessionManager Class
    private fun subscribeObservers() {
        sessionManager.getAuthUser().observe(this,
            Observer<AuthResource<User>> {
                when (it) {
                    is AuthResource.Success -> {

                    }
                    is AuthResource.Loading -> {

                    }
                    is AuthResource.Error -> {

                    }
                    is AuthResource.Logout -> {
                        Log.d(TAG, "##### LOGOUT TEST SUCCESSFUL #####");
                        navLoginScreen()
                    }
                }
            })
    }

    private fun navLoginScreen() {
        val intent = Intent(this, AuthLoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}