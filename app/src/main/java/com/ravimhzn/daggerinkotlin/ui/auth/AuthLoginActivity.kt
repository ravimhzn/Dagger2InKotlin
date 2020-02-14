package com.ravimhzn.daggerinkotlin.ui.auth

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.RequestManager
import com.google.android.material.textfield.TextInputEditText
import com.ravimhzn.daggerinkotlin.R
import com.ravimhzn.daggerinkotlin.models.User
import com.ravimhzn.daggerinkotlin.ui.main.MainActivity
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject


class AuthLoginActivity : DaggerAppCompatActivity(), View.OnClickListener {

    private val TAG = "AuthLoginActivity::"

    @Inject
    lateinit var providerFactory: ViewModelProvider.Factory

    lateinit var viewModel: AuthLoginViewModel

    @Inject
    lateinit var requestManager: RequestManager

    @Inject
    lateinit var dLogo: Drawable

    private lateinit var imgLogo: ImageView

    private lateinit var etUserId: TextInputEditText

    private lateinit var progressBar: ProgressBar


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        initiateViewModel()
        initViews()
        subscribeToObservers()
    }

    private fun initViews() {
        etUserId = findViewById(R.id.user_id_input)
        imgLogo = findViewById<ImageView>(R.id.imgLoginLogo)
        requestManager.load(dLogo).into(imgLogo)
        findViewById<Button>(R.id.btn_login).setOnClickListener(this)
        progressBar = findViewById(R.id.progress_bar)
    }

    private fun attemptLogin() {
        if (TextUtils.isEmpty(etUserId.text.toString())) {
            etUserId.error = "User Id cannot be empty"
            return
        }
        viewModel.authenticateWithUserId(Integer.parseInt(etUserId.text.toString()))
    }

    private fun subscribeToObservers() {
        viewModel.observeAuthUser().observe(this,
            Observer<AuthResource<User>> {
                when (it) {
                    is AuthResource.Success -> {
                        showProgressBar(false)
                        Log.d(TAG, "LOGIN SUCCESS:: ${it.data?.email}")
                        onLoginSuccess()
                    }
                    is AuthResource.Loading -> {
                        showProgressBar(true)
                    }
                    is AuthResource.Error -> {
                        showProgressBar(false)
                        Log.d(TAG, "ERROR OCCURED")
                        Toast.makeText(this, "Error occured", Toast.LENGTH_SHORT).show()
                    }
                    is AuthResource.Logout -> {
                        //Log.d(TAG, "##### LOGOUT TEST FROM LOADING #####");
                    }
                }
            })
    }


    private fun onLoginSuccess() {
        Log.d(TAG, "onLoginSuccess: login successful!")
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun showProgressBar(isVisible: Boolean) {
        progressBar.visibility = if (isVisible) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }

    private fun initiateViewModel() {
        viewModel =
            ViewModelProvider(this, providerFactory).get(AuthLoginViewModel::class.java)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btn_login -> {
                attemptLogin()
            }
        }
    }


}
