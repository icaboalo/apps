package com.icaboalo.aplications.io.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by icaboalo on 16/05/16.
 */
class LabelApiModel : Serializable {

    constructor(label: String, attributes: AttributesApiModel) {
        this.label = label
        this.attributes = attributes
    }

    @SerializedName("label")
    var label: String

    @SerializedName("attributes")
    var attributes: AttributesApiModel


}

