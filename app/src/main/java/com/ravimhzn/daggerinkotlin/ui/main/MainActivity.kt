package com.ravimhzn.daggerinkotlin.ui.main

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.ravimhzn.daggerinkotlin.BaseActivity
import com.ravimhzn.daggerinkotlin.R

class MainActivity : BaseActivity() {

    val TAG = MainActivity::class.java.name


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        testFragment()
    }

    private fun testFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, ProfileFragment())
            .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.logout -> {
                Log.d(TAG, "Logout clicked")
                sessionManager.logout()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }
}
