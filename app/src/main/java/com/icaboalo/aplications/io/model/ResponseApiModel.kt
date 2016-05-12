package com.icaboalo.aplications.io.model

import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * Created by icaboalo on 12/05/16.
 */
class ResponseApiModel{

    constructor(feed: Feed) {
        this.feed = feed
    }

    @SerializedName("feed")
    var feed: Feed

    class Feed{

        constructor(entry: ArrayList<EntryApiModel>) {
            this.entry = entry
        }

        @SerializedName("entry")
        var entry: ArrayList<EntryApiModel>
    }
}