package com.icaboalo.aplications.ui.activity

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.MenuItem
import com.icaboalo.aplications.AppModel
import com.icaboalo.aplications.R
import com.icaboalo.aplications.io.ApiClient
import com.icaboalo.aplications.io.model.EntryApiModel
import com.icaboalo.aplications.io.model.ResponseApiModel
import com.icaboalo.aplications.ui.fragment.CategoryFragment
import com.icaboalo.aplications.ui.fragment.HomeFragment
import com.icaboalo.aplications.util.VUtil
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class MainActivity : AppCompatActivity() {

    var entryList: ArrayList<AppModel>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(app_bar as Toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        if (VUtil().getOrientation(this@MainActivity)){
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

        }else{
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }
        navigationViewOnClick()
//        replaceFragment(HomeFragment().newInstance(entryList!!))

        val realm = Realm.getDefaultInstance()
        val query = realm.where(AppModel::class.java).findAll()
        for (item in query){

        }

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId){
            android.R.id.home -> {
                drawer_layout.openDrawer(GravityCompat.START)
            }
        }
        return super.onOptionsItemSelected(item)
    }


    fun navigationViewOnClick() {
        navigation_view.setNavigationItemSelectedListener { item ->
            var fragment: Fragment? = null
            when (item.itemId) {
                R.id.action_home -> {
                    if (entryList != null){
//                        fragment = HomeFragment().newInstance(entryList!!)
                    }
                }
                R.id.action_categories -> {
                    if (entryList != null){
//                        fragment = CategoryFragment().newInstance(entryList!!)
                    }
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
