package com.icaboalo.aplications.ui.activity


import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.v7.app.ActionBarActivity
import android.view.Window
import com.icaboalo.aplications.R
import java.util.*


class SplashScreenActivity : ActionBarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_splash_screen)

        if(resources.getBoolean(R.bool.is_phone)){
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }else{
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        }


        val task = object : TimerTask() {
            override fun run() {
                val goHome = Intent(this@SplashScreenActivity, MainActivity::class.java)
                startActivity(goHome)
                finish()
            }
        }
        val timer = Timer()
        timer.schedule(task, SPLASH_SCREEN_DELAY)
    }

    companion object {
        private val SPLASH_SCREEN_DELAY: Long = 3000
    }
}
