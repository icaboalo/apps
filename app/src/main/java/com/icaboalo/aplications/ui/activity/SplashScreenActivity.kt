package com.icaboalo.aplications.ui.activity


import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.v7.app.ActionBarActivity
import android.util.Log
import android.view.Window
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.icaboalo.aplications.AppModel
import com.icaboalo.aplications.R
import com.icaboalo.aplications.io.ApiClient
import com.icaboalo.aplications.io.model.EntryApiModel
import com.icaboalo.aplications.io.model.ResponseApiModel
import com.icaboalo.aplications.ui.fragment.HomeFragment
import com.icaboalo.aplications.util.VUtil
import io.realm.DynamicRealm
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmMigration
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*


class SplashScreenActivity : ActionBarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_splash_screen)

        if (VUtil().getOrientation(this)){
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

        }else{
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }

//        // Create a RealmConfiguration which is to locate Realm file in package's "files" directory.
//        var realmConfig =  RealmConfiguration.Builder(this).build();
//        // Get a Realm instance for this thread
//        var realm = Realm.getInstance(realmConfig);
        getEntries()
    }


//    fun getEntries(){
//        val call: Call<ResponseApiModel> = ApiClient().getApiService().getResponse();
//        call.enqueue(object: Callback<ResponseApiModel> {
//
//            override fun onResponse(call: Call<ResponseApiModel>, response: Response<ResponseApiModel>) {
//                if (response.isSuccessful){
//                    val entryList: ArrayList<EntryApiModel> = response.body().feed.entry
//                    val goHome = Intent(this@SplashScreenActivity, MainActivity::class.java)
//                    goHome.putExtra("ENTRIES", entryList)
//                    startActivity(goHome)
//                    finish()
//                    Log.d("JSON", response.body().toString())
////                    for (item in entryList){
////                        realm.beginTransaction()
//////                        val entry = realm.createObject(EntryApiModel::class.java)
//////                        entry.
////
////                    }
//                }
//            }
//            override fun onFailure(call: Call<ResponseApiModel>?, t: Throwable?) {
//                getEntries()
//            }
//        })
//    }

    fun getEntries(){
        val call: Call<ResponseBody> = ApiClient().getApiService().getResponse();
        call.enqueue(object: Callback<ResponseBody> {

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful){
//                    val entryList: ArrayList<EntryApiModel> = response.body().feed.entry
//                    val goHome = Intent(this@SplashScreenActivity, MainActivity::class.java)
//                    goHome.putExtra("ENTRIES", entryList)
//                    startActivity(goHome)
//                    finish()

                   saveInRealm(response.body().string())
                    //                    for (item in entryList){
                    //                        realm.beginTransaction()
                    ////                        val entry = realm.createObject(EntryApiModel::class.java)
                    ////                        entry.
                    //
                    //                    }
                }
            }
            override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
                getEntries()
            }
        })
    }

    fun saveInRealm(json: String){

        val migration = RealmMigration() {
            dynamicRealm: DynamicRealm, oldVersion: Long, l1: Long ->

            val schema = dynamicRealm.schema

            if (oldVersion == 0L){
                schema.create("AppModel")
                        .addField("position", Int::class.java)
                        .addField("name", String::class.java)
                        .addField("image", String::class.java)
                        .addField("category", String::class.java)
                        .addField("link", String::class.java)
                        .addField("rights", String::class.java)
                        .addField("summary", String::class.java)
                        .addField("releaseDate", String::class.java)
                        .addField("appPackage", String::class.java)
            }

        }
        // Create a RealmConfiguration which is to locate Realm file in package's "files" directory.
        val realmConfig = RealmConfiguration.Builder(this).migration(migration).build()
        // Get a Realm instance for this thread
        Realm.setDefaultConfiguration(realmConfig)
        Realm.deleteRealm(realmConfig);

        // Open the Realm with encryption enabled
        val realm = Realm.getInstance(realmConfig);
        val response = JSONObject(json)

        val entries = response.getJSONObject("feed").getJSONArray("entry")
        var count: Int = 0
        while (count < entries.length()){
            realm.beginTransaction()
            val entry = entries.getJSONObject(count)
            val app = realm.createObject(AppModel::class.java)
            app.position = count+1
            app.name = entry.getJSONObject("im:name").getString("label")
            app.category = entry.getJSONObject("category").getJSONObject("attributes").getString("label")
            app.image = entry.getJSONArray("im:image").getJSONObject(2).getString("label")
            app.link = entry.getJSONObject("id").getString("label")
            app.appPackage = entry.getJSONObject("id").getJSONObject("attributes").getString("im:bundleId")
            app.rights = entry.getJSONObject("rights").getString("label")
            app.releaseDate = entry.getJSONObject("im:releaseDate").getJSONObject("attributes").getString("label")
            app.summary = entry.getJSONObject("summary").getString("label")
            realm.copyFromRealm(app)
            realm.commitTransaction()
            count ++
        }

        val goHome = Intent(this@SplashScreenActivity, MainActivity::class.java)
        startActivity(goHome)
        finish()
    }
}
