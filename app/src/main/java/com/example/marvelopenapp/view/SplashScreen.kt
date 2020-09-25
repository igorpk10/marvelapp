package com.example.marvelopenapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.marvelopenapp.MainActivity
import com.example.marvelopenapp.R

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        initHandler()
    }

    private fun initHandler() {
        Handler().postDelayed({
            startActivity(MainActivity.newIntent(this))
            finish()
        }, 5000)
    }
}