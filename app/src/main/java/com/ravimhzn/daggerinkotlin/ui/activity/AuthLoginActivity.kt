package com.ravimhzn.daggerinkotlin.ui.activity

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.ravimhzn.daggerinkotlin.R
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class AuthLoginActivity : DaggerAppCompatActivity() {

    var TAG = "AuthLoginActivity"

    @Inject
    lateinit var homeTextInjectedFromDaggerModule: String

    private lateinit var tvAuthLoginText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        tvAuthLoginText = findViewById<TextView>(R.id.tvAuthLoginTitle)
        tvAuthLoginText.text = homeTextInjectedFromDaggerModule
    }
}
