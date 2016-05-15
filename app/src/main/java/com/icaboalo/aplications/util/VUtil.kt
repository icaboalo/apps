package com.icaboalo.aplications.util

import android.content.Context
import android.content.pm.ActivityInfo
import com.icaboalo.aplications.R

/**
 * Created by icaboalo on 15/05/16.
 */
class VUtil{
    fun getOrientation(context: Context): Boolean{
        if(context.resources.getBoolean(R.bool.is_phone)){
            return true
        }else{
            return false
        }
    }
}