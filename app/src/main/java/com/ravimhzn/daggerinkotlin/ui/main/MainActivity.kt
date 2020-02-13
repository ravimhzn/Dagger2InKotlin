package com.ravimhzn.daggerinkotlin.ui.main

import android.os.Bundle
import android.os.PersistableBundle
import com.ravimhzn.daggerinkotlin.BaseActivity
import com.ravimhzn.daggerinkotlin.R

class MainActivity : BaseActivity() {

    private var TAG = MainActivity::class.java.name

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_main)
    }

}