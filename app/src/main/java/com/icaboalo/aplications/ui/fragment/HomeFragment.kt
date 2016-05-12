package com.icaboalo.aplications.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.icaboalo.aplications.R
import com.icaboalo.aplications.io.model.EntryApiModel
import java.util.*

/**
 * Created by icaboalo on 12/05/16.
 */
class HomeFragment: Fragment() {

    var listView: ListView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listView = view.findViewById(R.id.list_view) as ListView?
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    fun setupListView(list: ArrayList<EntryApiModel>){

    }
}