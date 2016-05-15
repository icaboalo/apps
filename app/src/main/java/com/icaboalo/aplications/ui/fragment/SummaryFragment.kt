package com.icaboalo.aplications.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.icaboalo.aplications.R
import com.icaboalo.aplications.io.model.EntryApiModel

/**
 * Created by icaboalo on 12/05/16.
 */
class SummaryFragment : Fragment(){

    fun newInstance(entry: EntryApiModel): SummaryFragment {
        val fragment = SummaryFragment()
        val args = Bundle()
        args.putSerializable("APP", entry)
        fragment.arguments = args
        return fragment
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_summary,  container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val entry = arguments.getSerializable("APP") as EntryApiModel
        val summary = view.findViewById(R.id.summary) as TextView
        val rights = view.findViewById(R.id.rights) as TextView

        summary.text = entry.summary.label
        rights.text = entry.rights.label

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}