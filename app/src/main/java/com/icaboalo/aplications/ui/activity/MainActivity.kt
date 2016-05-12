package com.icaboalo.aplications.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.Toolbar
import com.icaboalo.aplications.R

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(app_bar as Toolbar)

        navigationViewOnClick()

    }

    fun navigationViewOnClick() {
        navigation_view.setNavigationItemSelectedListener { item ->
            var fragment: Fragment? = null
            when (item.itemId) {
//                R.id.action_capture_list -> {
//                    fragment = PurchasesFragment()
//                }
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
