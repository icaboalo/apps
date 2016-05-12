package com.icaboalo.aplications.ui.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.icaboalo.aplications.R
import com.icaboalo.aplications.io.model.EntryApiModel
import com.squareup.picasso.Picasso

/**
 * Created by icaboalo on 12/05/16.
 */
class GetFragment: Fragment(), View.OnClickListener{

    fun newInstance(app: EntryApiModel): GetFragment{
        val fragment = GetFragment()
        var args = Bundle()
        args.putSerializable("APP", app)
        fragment.arguments = args
        return fragment
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_get, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val image = view.findViewById(R.id.app_image) as ImageView
        val package_ = view.findViewById(R.id.package_text) as TextView
        val releaseDate = view.findViewById(R.id.release_date) as TextView
        val getButton = view.findViewById(R.id.get_button) as Button

        val entry = arguments.getSerializable("APP") as EntryApiModel
        Picasso.with(activity).load(entry.images[2].label).into(image)
        package_.text = entry.id.attributes.bundleId
        releaseDate.text = entry.releaseDate.attributes.label
        getButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val entry = arguments.getSerializable("APP") as EntryApiModel
        val goToDownload = Intent(Intent.ACTION_VIEW, Uri.parse(entry.link.attributes.refUrl))
        startActivity(goToDownload)
    }
}