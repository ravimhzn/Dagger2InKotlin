package com.ravimhzn.daggerinkotlin.ui.auth

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.RequestManager
import com.google.android.material.textfield.TextInputEditText
import com.ravimhzn.daggerinkotlin.R
import com.ravimhzn.daggerinkotlin.models.User
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


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initiateViewModel()
        initViews()
        subscribeToObservers()
    }

    private fun initViews() {
        etUserId = findViewById(R.id.user_id_input)
        imgLogo = findViewById<ImageView>(R.id.imgLoginLogo)
        requestManager.load(dLogo).into(imgLogo)
        findViewById<Button>(R.id.btn_login).setOnClickListener(this)
    }

    private fun subscribeToObservers() {
        viewModel.observeUser().observe(this, object : Observer<User> {
            override fun onChanged(t: User?) {
                t?.let {
                    Log.d(TAG, "EMAIL:::: ${t.email}")
                }
            }
        })
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

    private fun attemptLogin() {
        if (TextUtils.isEmpty(etUserId.text.toString())) {
            etUserId.error = "User Id cannot be empty"
            return
        }

        viewModel.authenticateWithMediatorLiveDataId(Integer.parseInt(etUserId.text.toString()))

        //withoutUsingMediatorLiveData()
    }

    private fun withoutUsingMediatorLiveData() {
        viewModel.authenticateWithId(Integer.parseInt(etUserId.text.toString()))
            .observe(this, object : Observer<User> {
                override fun onChanged(t: User?) {
                    Log.d(TAG, "EMAIL::: (WITHOUT MLV) ${t?.email}")
                }

            })
    }
}
