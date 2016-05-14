package com.icaboalo.aplications.ui.fragment

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.icaboalo.aplications.R
import com.icaboalo.aplications.io.ApiClient
import com.icaboalo.aplications.io.model.EntryApiModel
import com.icaboalo.aplications.io.model.ResponseApiModel
import com.icaboalo.aplications.ui.activity.DetailActivity
import com.icaboalo.aplications.ui.adapter.AppRecyclerAdapter
import com.icaboalo.aplications.ui.adapter.OnViewHolderImageClick
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.Serializable
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
                getEntries()
            }
        })
    }

    fun setupListView(list: ArrayList<EntryApiModel>){
        val appRecyclerAdapter = AppRecyclerAdapter(activity, list, object: OnViewHolderImageClick {
            override fun onClick(v: View, position: Int, imageView: ImageView) {
                val entry = list[position]
                val goToDetail: Intent = Intent(activity, DetailActivity::class.java)
                goToDetail.putExtra("ENTRY", entry as Serializable)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    val options: ActivityOptionsCompat  = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, imageView, "activity_image_trans")
                    startActivity(goToDetail, options.toBundle())
                }
                else {
                    startActivity(goToDetail)
                }
            }

        })
        val linearLayout = LinearLayoutManager(activity)
        appRecycler?.adapter = appRecyclerAdapter
        appRecycler?.layoutManager = linearLayout
    }
}