package com.icaboalo.aplications.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.icaboalo.aplications.R
import com.icaboalo.aplications.io.ApiClient
import com.icaboalo.aplications.io.model.EntryApiModel
import com.icaboalo.aplications.io.model.ResponseApiModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

/**
 * Created by icaboalo on 12/05/16.
 */
class HomeFragment: Fragment() {

    var appRecycler: RecyclerView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        appRecycler = view.findViewById(R.id.app_recycler) as RecyclerView?
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        getEntries()
    }

    fun getEntries(){
        val call: Call<ResponseApiModel> = ApiClient().getApiService().getResponse();
        call.enqueue(object: Callback<ResponseApiModel>{

            override fun onResponse(call: Call<ResponseApiModel>, response: Response<ResponseApiModel>) {
                if (response.isSuccessful){
                    val entryList: ArrayList<EntryApiModel> = response.body().feed.entry

                    setupListView(entryList)
                }

            }

            override fun onFailure(call: Call<ResponseApiModel>?, t: Throwable?) {
                throw UnsupportedOperationException()
            }
        })
    }

    fun setupListView(list: ArrayList<EntryApiModel>){
//        val entryAdapter = EntryBaseAdapter(context)
//        Log.d("UNORDER", list.toString())
//        Collections.sort(list, CustomComparator())
//        Log.d("ORDER", list.toString())
//        val categoryList = ArrayList<String>()
//        for (entry in list){
//            if (!categoryList.contains(entry.category.attributes.label)){
//                categoryList.add(entry.category.attributes.label)
//                entryAdapter.addSectionHeaderItem(entry)
//            }
//            entryAdapter.addItem(entry)
//        }
//        listView!!.adapter = entryAdapter
//        Log.d("CATEGORY", categoryList.toString())
    }

    class CustomComparator: Comparator<EntryApiModel>{
        override fun compare(entry1: EntryApiModel, entry2: EntryApiModel): Int {
            return entry1.category.attributes.label.compareTo(entry1.category.attributes.label)
        }

    }
}