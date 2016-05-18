package com.icaboalo.aplications.ui.activity


import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.v7.app.ActionBarActivity
import android.view.Window
import com.icaboalo.aplications.R
import com.icaboalo.aplications.io.ApiClient
import com.icaboalo.aplications.io.model.EntryApiModel
import com.icaboalo.aplications.io.model.ResponseApiModel
import com.icaboalo.aplications.util.VUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
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

        getEntries()
    }


    fun getEntries(){
        val call: Call<ResponseApiModel> = ApiClient().getApiService().getResponse();
        call.enqueue(object: Callback<ResponseApiModel> {

            override fun onResponse(call: Call<ResponseApiModel>, response: Response<ResponseApiModel>) {
                if (response.isSuccessful){
                    val entryList: ArrayList<EntryApiModel> = response.body().feed.entry
                    val goHome = Intent(this@SplashScreenActivity, MainActivity::class.java)
                    goHome.putExtra("ENTRIES", entryList)
                    startActivity(goHome)
                    finish()
                }
            }
            override fun onFailure(call: Call<ResponseApiModel>?, t: Throwable?) {
                getEntries()
            }
        })
    }
}