package com.icaboalo.aplications.ui.adapter

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

import java.util.ArrayList

/**
 * Created by icaboalo on 9/26/2015.
 */
class MyViewPagerAdapter(fm: FragmentManager, pagerList: List<ModelFragmentPager>) : FragmentPagerAdapter(fm) {

    class ModelFragmentPager(val pager: Fragment, val title: String)

    internal var pagerList: List<ModelFragmentPager> = ArrayList()

    init {
        this.pagerList = pagerList
    }

    override fun getItem(position: Int): Fragment {
        return pagerList[position].pager
    }

    override fun getCount(): Int {
        return pagerList.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return pagerList[position].title
    }
}
