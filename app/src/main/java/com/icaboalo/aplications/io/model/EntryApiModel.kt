package com.icaboalo.aplications.io.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.*

/**
 * Created by icaboalo on 12/05/16.
 */
class EntryApiModel: Serializable {

    constructor(name: Label, images: ArrayList<Label>, summary: Label, price: Label, contentType: Label, rights: Label, title: Label, link: Label, id: Label, artist: Label, category: Label, releaseDate: Label) {
        this.name = name
        this.images = images
        this.summary = summary
        this.price = price
        this.contentType = contentType
        this.rights = rights
        this.title = title
        this.link = link
        this.id = id
        this.artist = artist
        this.category = category
        this.releaseDate = releaseDate
    }

    @SerializedName("im:name")
    var name: Label

    @SerializedName("im:image")
    var images: ArrayList<Label>

    @SerializedName("summary")
    var summary: Label

    @SerializedName("im:price")
    var price: Label

    @SerializedName("im:contentType")
    var contentType: Label

    @SerializedName("rights")
    var rights: Label

    @SerializedName("title")
    var title: Label

    @SerializedName("link")
    var link: Label

    @SerializedName("id")
    var id: Label

    @SerializedName("im:artist")
    var artist: Label

    @SerializedName("category")
    var category: Label

    @SerializedName("im:releaseDate")
    var releaseDate: Label

    class Label: Serializable{

        constructor(label: String, attributes: Attributes) {
            this.label = label
            this.attributes = attributes
        }

        @SerializedName("label")
        var label: String

        @SerializedName("attributes")
        var attributes: Attributes

        class Attributes: Serializable{

            constructor(height: String, amount: String, currency: String, term: String, label: String, rel: String, type: String, refUrl: String, id: String, bundleId: String, scheme: String) {
                this.height = height
                this.amount = amount
                this.currency = currency
                this.term = term
                this.label = label
                this.rel = rel
                this.type = type
                this.refUrl = refUrl
                this.id = id
                this.bundleId = bundleId
                this.scheme = scheme
            }

            @SerializedName("height")
            var height: String

            @SerializedName("amount")
            var amount: String

            @SerializedName("currency")
            var currency: String

            @SerializedName("term")
            var term: String

            @SerializedName("label")
            var label: String

            @SerializedName("rel")
            var rel: String

            @SerializedName("type")
            var type: String

            @SerializedName("href")
            var refUrl: String

            @SerializedName("im:id")
            var id: String

            @SerializedName("im:bundleId")
            var bundleId: String

            @SerializedName("scheme")
            var scheme: String

        }
    }

    override fun toString(): String {
        return name.label
    }
}