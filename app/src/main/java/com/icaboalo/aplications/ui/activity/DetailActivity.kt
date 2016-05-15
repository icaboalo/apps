package com.icaboalo.aplications.ui.activity

import android.content.Intent
import android.content.pm.ActivityInfo
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import com.icaboalo.aplications.R
import com.icaboalo.aplications.io.model.EntryApiModel
import com.icaboalo.aplications.util.VUtil
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity(), View.OnClickListener {

    var entry: EntryApiModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(app_bar as Toolbar)

        if (VUtil().getOrientation(this)){
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

        }else{
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }

        entry = intent.getSerializableExtra("ENTRY") as EntryApiModel
        supportActionBar!!.title = entry!!.name.label
        supportActionBar!!.subtitle = entry!!.category.attributes.label
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        Picasso.with(this).load(entry!!.images[2].label).into(app_image)
        package_text.text = entry!!.id.attributes.bundleId
        release_date.text = entry!!.releaseDate.attributes.label
        summary.text = entry!!.summary.label
        rights.text = entry!!.rights.label
        get_button.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val entry = intent.getSerializableExtra("ENTRY") as EntryApiModel
        val goToDownload = Intent(Intent.ACTION_VIEW, Uri.parse(entry.link.attributes.refUrl))
        startActivity(goToDownload)
    }



}
