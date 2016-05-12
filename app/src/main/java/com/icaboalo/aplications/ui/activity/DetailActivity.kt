package com.icaboalo.aplications.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.icaboalo.aplications.R
import com.icaboalo.aplications.io.model.EntryApiModel
import com.icaboalo.aplications.ui.adapter.MyViewPagerAdapter
import com.icaboalo.aplications.ui.adapter.MyViewPagerAdapter.ModelFragmentPager
import com.icaboalo.aplications.ui.fragment.GetFragment
import kotlinx.android.synthetic.main.activity_detail.*
import java.util.*

class DetailActivity : AppCompatActivity() {

    var entry: EntryApiModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(app_bar as Toolbar)
        entry = intent.getSerializableExtra("ENTRY") as EntryApiModel
        supportActionBar!!.title = entry!!.name.label
        supportActionBar!!.subtitle = entry!!.category.attributes.label
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        setUpTabs()
    }

    private fun setUpTabs() {
        val viewPagerAdapter = MyViewPagerAdapter(supportFragmentManager, createPager())
        view_pager.adapter = viewPagerAdapter
        tab_layout.setupWithViewPager(view_pager)
    }

    fun createPager(): ArrayList<ModelFragmentPager>{
        val fragmentList: ArrayList<ModelFragmentPager> = ArrayList()
        fragmentList.add(ModelFragmentPager(GetFragment().newInstance(entry!!), "GET"))
//        fragmentList.add(ModelFragmentPager(HomeFragment(), "Summary"))
        return fragmentList
    }

}
