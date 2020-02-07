package com.ravimhzn.daggerinkotlin.ui.activity

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.RequestManager
import com.ravimhzn.daggerinkotlin.R
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class AuthLoginActivity : DaggerAppCompatActivity() {



    var TAG = "AuthLoginActivity::"

    @Inject
    lateinit var requestManager: RequestManager

    @Inject
    lateinit var dLogo: Drawable

    private lateinit var imgLogo: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imgLogo = findViewById<ImageView>(R.id.imgLoginLogo)
        requestManager.load(dLogo).into(imgLogo)
    }
}
