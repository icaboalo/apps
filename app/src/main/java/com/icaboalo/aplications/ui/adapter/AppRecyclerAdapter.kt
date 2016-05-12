package com.icaboalo.aplications.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.icaboalo.aplications.io.model.EntryApiModel
import java.util.*

/**
 * Created by icaboalo on 12/05/16.
 */
class AppRecyclerAdapter: RecyclerView.Adapter<AppRecyclerAdapter.AppViewHolder> {

    var context: Context
    var entryList: ArrayList<EntryApiModel>
    var inflater: LayoutInflater
    var viewHolderClick: OnViewHolderClick

    constructor(context: Context, entryList: ArrayList<EntryApiModel>, viewHolderClickListener: OnViewHolderClick) : super() {
        this.context = context
        this.entryList = entryList
        this.inflater = LayoutInflater.from(context)
        this.viewHolderClick = viewHolderClickListener
    }


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): AppViewHolder? {
        throw UnsupportedOperationException()
    }

    override fun onBindViewHolder(holder: AppViewHolder?, position: Int) {

    }

    override fun getItemCount(): Int {
        return entryList.size
    }

    inner class AppViewHolder: RecyclerView.ViewHolder, View.OnClickListener {

        var viewHolderClick: OnViewHolderClick

        constructor(itemView: View, viewHolderClickListener: OnViewHolderClick) : super(itemView){
            this.viewHolderClick = viewHolderClickListener
        }

        override fun onClick(v: View) {
            viewHolderClick.onClick(v, adapterPosition)
        }
    }
}