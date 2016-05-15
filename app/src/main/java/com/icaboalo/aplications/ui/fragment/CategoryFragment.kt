package com.icaboalo.aplications.ui.fragment

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.icaboalo.aplications.R
import com.icaboalo.aplications.ui.adapter.MyViewPagerAdapter
import java.util.*

/**
 * Created by icaboalo on 15/05/16.
 */
class CategoryFragment: Fragment(){

    var tabLayout: TabLayout? = null
    var viewPager: ViewPager? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tabLayout = view.findViewById(R.id.tab_layout) as TabLayout
        viewPager = view.findViewById(R.id.view_pager) as ViewPager
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    fun setupTabs(pagerList: ArrayList<MyViewPagerAdapter.ModelFragmentPager>){
        viewPager?.adapter = MyViewPagerAdapter(childFragmentManager, pagerList)
        tabLayout?.setupWithViewPager(viewPager)
    }
}