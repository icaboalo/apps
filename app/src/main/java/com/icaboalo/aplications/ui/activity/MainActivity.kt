package com.icaboalo.aplications.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.icaboalo.aplications.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

//    fun navigationViewOnClick() {
//        mNavigationView!!.setNavigationItemSelectedListener { item ->
//            var fragment: Fragment? = null
//            when (item.itemId) {
//                R.id.action_capture_list -> {
//                    fragment = PurchasesFragment()
//                }
//            }
//            replaceFragment(fragment!!)
//            mDrawerLayout!!.closeDrawers()
//            false
//        }
//    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
    }
}
