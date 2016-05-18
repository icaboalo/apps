package com.icaboalo.aplications.ui.adapter

import android.view.View
import android.widget.ImageView

/**
 * Created by icaboalo on 13/05/16.
 */
interface OnViewHolderImageClick {
    fun onClick(v: View, position: Int, imageView: ImageView)

}