package com.ravimhzn.daggerinkotlin

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
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
    // That way it will catch for any changes made on SessionManager Class
    private fun subscribeObservers() {
        sessionManager.getAuthUser().observe(this, Observer {
            when (it) {
                is AuthResource.Success -> {
                    Toast.makeText(
                        this,
                        "LOGIN SUCCESS:: ${it.data?.email}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                is AuthResource.Loading -> {

                }
                is AuthResource.Error -> {
                    Log.d(TAG, "ERROR OCCURED")
                    Toast.makeText(this, "Error occured", Toast.LENGTH_SHORT).show()
                }
                is AuthResource.Logout -> {
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