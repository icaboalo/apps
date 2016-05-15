package com.icaboalo.aplications.ui.activity

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.icaboalo.aplications.R
import com.icaboalo.aplications.ui.fragment.CategoryFragment
import com.icaboalo.aplications.ui.fragment.HomeFragment
import com.icaboalo.aplications.util.VUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(app_bar as Toolbar)

        if (VUtil().getOrientation(this@MainActivity)){
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

        }else{
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }
        replaceFragment(HomeFragment())
        navigationViewOnClick()
    }

    fun navigationViewOnClick() {
        navigation_view.setNavigationItemSelectedListener { item ->
            var fragment: Fragment? = null
            when (item.itemId) {
                R.id.action_home -> {
                    fragment = HomeFragment()
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
