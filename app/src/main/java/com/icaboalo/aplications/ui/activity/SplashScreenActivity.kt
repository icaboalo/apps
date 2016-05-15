package com.icaboalo.aplications.ui.activity


import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.v7.app.ActionBarActivity
import android.view.Window
import com.icaboalo.aplications.R
import com.icaboalo.aplications.util.VUtil
import java.util.*


class SplashScreenActivity : ActionBarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_splash_screen)

        if (VUtil().getOrientation(this)){
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

        }else{
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
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
