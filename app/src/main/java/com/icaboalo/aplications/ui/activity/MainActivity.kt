package com.icaboalo.aplications.ui.activity

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import com.icaboalo.aplications.R
import com.icaboalo.aplications.io.ApiClient
import com.icaboalo.aplications.io.model.EntryApiModel
import com.icaboalo.aplications.io.model.ResponseApiModel
import com.icaboalo.aplications.ui.fragment.CategoryFragment
import com.icaboalo.aplications.ui.fragment.HomeFragment
import com.icaboalo.aplications.util.VUtil
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class MainActivity : AppCompatActivity() {

    var entryList: ArrayList<EntryApiModel>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(app_bar as Toolbar)

        if (VUtil().getOrientation(this@MainActivity)){
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

        }else{
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }
        navigationViewOnClick()
        getEntries()
    }

    fun getEntries(){
        val call: Call<ResponseApiModel> = ApiClient().getApiService().getResponse();
        call.enqueue(object: Callback<ResponseApiModel> {

            override fun onResponse(call: Call<ResponseApiModel>, response: Response<ResponseApiModel>) {
                if (response.isSuccessful){
                    Log.d("SUCCES", "succes")
                    val entryList: ArrayList<EntryApiModel> = response.body().feed.entry
                    this@MainActivity.entryList = entryList
                    replaceFragment(HomeFragment().newInstance(entryList))
                }
            }
            override fun onFailure(call: Call<ResponseApiModel>?, t: Throwable?) {
                getEntries()
            }
        })
    }

    fun navigationViewOnClick() {
        navigation_view.setNavigationItemSelectedListener { item ->
            var fragment: Fragment? = null
            when (item.itemId) {
                R.id.action_home -> {
                    if (entryList != null){
                        fragment = HomeFragment().newInstance(entryList!!)
                    }
                }
                R.id.action_categories -> {
                    fragment = CategoryFragment()
                }
                R.id.action_search -> {

                }
            }
            replaceFragment(fragment!!)
            drawer_layout.closeDrawers()
            false
        }
    }

    fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
    }
}
