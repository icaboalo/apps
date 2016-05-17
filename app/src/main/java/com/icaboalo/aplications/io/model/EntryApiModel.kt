package com.icaboalo.aplications.io.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.*

/**
 * Created by icaboalo on 12/05/16.
 */
class EntryApiModel: Serializable {

    constructor(name: LabelApiModel, images: ArrayList<LabelApiModel>, summary: LabelApiModel, price: LabelApiModel, rights: LabelApiModel, id: LabelApiModel, artist: LabelApiModel, category: LabelApiModel, releaseDate: LabelApiModel) {
        this.name = name
        this.images = images
        this.summary = summary
        this.price = price
        this.rights = rights
        this.id = id
        this.artist = artist
        this.category = category
        this.releaseDate = releaseDate
    }

    @SerializedName("im:name")
    var name: LabelApiModel

    @SerializedName("im:image")
    var images: ArrayList<LabelApiModel>

    @SerializedName("summary")
    var summary: LabelApiModel

    @SerializedName("im:price")
    var price: LabelApiModel

    @SerializedName("rights")
    var rights: LabelApiModel

    @SerializedName("id")
    var id: LabelApiModel

    @SerializedName("im:artist")
    var artist: LabelApiModel

    @SerializedName("category")
    var category: LabelApiModel

    @SerializedName("im:releaseDate")
    var releaseDate: LabelApiModel

    override fun toString(): String {
        return name.label
    }
}