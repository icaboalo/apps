package com.icaboalo.aplications.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.icaboalo.aplications.R
import com.icaboalo.aplications.io.ApiClient
import com.icaboalo.aplications.io.model.EntryApiModel
import com.icaboalo.aplications.io.model.ResponseApiModel
import com.icaboalo.aplications.ui.adapter.EntryBaseAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
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
        getEntries()
    }

    fun getEntries(){
        val call: Call<ResponseApiModel> = ApiClient().getApiService().getResponse();
        call.enqueue(object: Callback<ResponseApiModel>{

            override fun onResponse(call: Call<ResponseApiModel>, response: Response<ResponseApiModel>) {
                if (response.isSuccessful){
                    val entryList: ArrayList<EntryApiModel> = response.body().feed.entry

                    for (entry in entryList){
                        Log.d("ENTRY", "${entry.name.label} \n ${entry.category.attributes.label}")
                    }
                }

            }

            override fun onFailure(call: Call<ResponseApiModel>?, t: Throwable?) {
                throw UnsupportedOperationException()
            }
        })
    }

    fun setupListView(list: ArrayList<EntryApiModel>){
//        entryAdapter = EntryBaseAdapter(context)
    }
//        mAdapter = new CustomAdapter(this);
//        for (int i = 1; i < 30; i++) {
//            mAdapter.addItem("Row Item #" + i);
//            if (i % 4 == 0) {
//                mAdapter.addSectionHeaderItem("Section #" + i);
//            }
//        }
//        setListAdapter(mAdapter);
//    }
}