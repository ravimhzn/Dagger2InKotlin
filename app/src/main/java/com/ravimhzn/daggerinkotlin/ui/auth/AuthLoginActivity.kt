package com.ravimhzn.daggerinkotlin.ui.auth

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.RequestManager
import com.ravimhzn.daggerinkotlin.R
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class AuthLoginActivity : DaggerAppCompatActivity() {

    private val TAG = "AuthLoginActivity::"

    @Inject
    lateinit var providerFactory: ViewModelProvider.Factory

    lateinit var authLoginActivityViewModel: AuthLoginViewModel

    @Inject
    lateinit var requestManager: RequestManager

    @Inject
    lateinit var dLogo: Drawable

    private lateinit var imgLogo: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        authLoginActivityViewModel =
            ViewModelProvider(this, providerFactory).get(AuthLoginViewModel::class.java)


        initiateViewModel()
        imgLogo = findViewById<ImageView>(R.id.imgLoginLogo)
        requestManager.load(dLogo).into(imgLogo)
    }

    private fun initiateViewModel() {

    }
}
