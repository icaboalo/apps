package com.icaboalo.aplications.io

import com.icaboalo.aplications.io.model.ResponseApiModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by icaboalo on 12/05/16.
 */
interface ApiService {

    @GET("json")
    fun getResponse(): Call<ResponseBody>
}