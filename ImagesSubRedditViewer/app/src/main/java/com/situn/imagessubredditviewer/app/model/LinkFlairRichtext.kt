package com.situn.imagessubredditviewer.app.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class LinkFlairRichtext {
    @SerializedName("e")
    @Expose
    var e: String? = null

    @SerializedName("t")
    @Expose
    var t: String? = null

}