package com.icaboalo.aplications.ui.fragment

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.icaboalo.aplications.R
import com.icaboalo.aplications.io.model.EntryApiModel
import com.icaboalo.aplications.ui.adapter.MyViewPagerAdapter
import java.util.*

/**
 * Created by icaboalo on 15/05/16.
 */
class CategoryFragment: Fragment(){

    var tabLayout: TabLayout? = null
    var viewPager: ViewPager? = null

    fun newInstance(entryList: ArrayList<EntryApiModel>): CategoryFragment{
        val fragment = CategoryFragment()
        val args = Bundle()
        args.putSerializable("ENTRIES", entryList)
        fragment.arguments = args
        return fragment
    }

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
        val entryList = arguments.getSerializable("ENTRIES") as ArrayList<EntryApiModel>
        getCategories(entryList)
    }

    fun getCategories(entryList: ArrayList<EntryApiModel>){
        var categoryList = ArrayList<String>()
        for (item in entryList){
            val category_name = item.category.attributes.label
            if (!categoryList.contains(category_name)){
                categoryList.add(category_name)
            }
        }
        setupTabs(categoryList)
    }

    fun setupTabs(titleList: ArrayList<String>){
        val pagerList = ArrayList<MyViewPagerAdapter.ModelFragmentPager>()
        for (title in titleList){
            pagerList.add(MyViewPagerAdapter.ModelFragmentPager(Fragment(), title))
        }
        viewPager?.adapter = MyViewPagerAdapter(childFragmentManager, pagerList)
        tabLayout?.setupWithViewPager(viewPager)
    }
}