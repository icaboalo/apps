package com.icaboalo.aplications.io.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by icaboalo on 16/05/16.
 */
class AttributesApiModel : Serializable {

    constructor(label: String, type: String, id: String, bundleId: String) {
        this.label = label
        this.type = type
        this.id = id
        this.bundleId = bundleId
    }

    @SerializedName("label")
    var label: String

    @SerializedName("type")
    var type: String

    @SerializedName("im:id")
    var id: String

    @SerializedName("im:bundleId")
    var bundleId: String

}