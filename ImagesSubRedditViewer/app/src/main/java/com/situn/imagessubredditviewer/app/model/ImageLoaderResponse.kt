package com.situn.imagessubredditviewer.app.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




public class ImageLoaderResponse{
    @SerializedName("kind")
    @Expose
    private var kind: String? = null

    @SerializedName("data")
    @Expose
    private var data: Data? = null

    fun getKind(): String? {
        return kind
    }

    fun setKind(kind: String?) {
        this.kind = kind
    }

    fun getData(): Data? {
        return data
    }

    fun setData(data: Data?) {
        this.data = data
    }
}