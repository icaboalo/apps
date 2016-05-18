package com.icaboalo.aplications.io

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by icaboalo on 12/05/16.
 */
class ApiClient {

    var mApiService: ApiService? = null

    fun getApiService(): ApiService {
        if (mApiService == null) {
            val nRetrofit = Retrofit.Builder()
                    .baseUrl("https://itunes.apple.com/us/rss/topfreeapplications/limit=20/")
                    .addConverterFactory(GsonConverterFactory.create()).build()
            mApiService = nRetrofit.create(ApiService::class.java)
        }
        return mApiService!!
    }
}