package com.icaboalo.aplications.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import android.widget.ImageView
import android.widget.TextView
import com.icaboalo.aplications.R
import com.icaboalo.aplications.io.model.EntryApiModel
import com.squareup.picasso.Picasso
import java.util.*

/**
 * Created by icaboalo on 12/05/16.
 */
class AppRecyclerAdapter: RecyclerView.Adapter<AppRecyclerAdapter.AppViewHolder> {

    var context: Context
    var entryList: ArrayList<EntryApiModel>
    var inflater: LayoutInflater
    var viewHolderClick: OnViewHolderImageClick

    constructor(context: Context, entryList: ArrayList<EntryApiModel>, viewHolderClickListener: OnViewHolderImageClick) : super() {
        this.context = context
        this.entryList = entryList
        this.inflater = LayoutInflater.from(context)
        this.viewHolderClick = viewHolderClickListener
    }


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): AppViewHolder? {
        val view: View = inflater.inflate(R.layout.item_aplication_adapter, parent, false)
        return AppViewHolder(view, R.id.app_name_text, R.id.category_text, R.id.app_image, R.id.position_text, viewHolderClick)
    }

    override fun onBindViewHolder(holder: AppViewHolder, position: Int) {
        val entry: EntryApiModel = entryList[position]
        holder.appPosition.text = "${position+1}"
        holder.appName.text = entry.name.label
        holder.appName.isSelected = true
        holder.appCategory.text = entry.category.attributes.label
        holder.setImage(entry.images[2].label)
    }

    override fun getItemCount(): Int {
        return entryList.size
    }

    inner class AppViewHolder: RecyclerView.ViewHolder, View.OnClickListener {


        var appImage: ImageView
        var appName: TextView
        var appCategory: TextView
        var appPosition: TextView
        var viewHolderClick: OnViewHolderImageClick

        constructor(itemView: View, appNameId: Int, appCategoryId: Int, appImageId: Int, appPositionId: Int, viewHolderClickListener: OnViewHolderImageClick) : super(itemView){
            this.viewHolderClick = viewHolderClickListener
            this.appImage = itemView.findViewById(appImageId) as ImageView
            this.appName = itemView.findViewById(appNameId) as TextView
            this.appCategory = itemView.findViewById(appCategoryId) as TextView
            this.appPosition = itemView.findViewById(appPositionId) as TextView
            appName.ellipsize = TextUtils.TruncateAt.MARQUEE
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            viewHolderClick.onClick(v, adapterPosition, appImage)
        }

        fun setImage(url: String){
            if (!url.isEmpty() || url != null){
                Picasso.with(context).load(url).placeholder(R.mipmap.ic_launcher).into(appImage)
            }else{
                appImage.setImageDrawable(null)
            }
        }

    }
}