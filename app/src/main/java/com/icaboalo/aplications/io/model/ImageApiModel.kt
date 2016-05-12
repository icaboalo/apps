package com.icaboalo.aplications.io.model

import com.google.gson.annotations.SerializedName

/**
 * Created by icaboalo on 12/05/16.
 */
class ImageApiModel{

    constructor(imageUrl: String, attributes: Attributes) {
        this.imageUrl = imageUrl
        this.attributes = attributes
    }

    @SerializedName("label")
    var imageUrl: String

    @SerializedName("attributes")
    var attributes: Attributes

    class Attributes{

        constructor(height: Int) {
            this.height = height
        }

        @SerializedName("height")
        var height: Int
    }
}