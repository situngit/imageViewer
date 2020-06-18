package com.situn.imagessubredditviewer.app.services

import com.situn.imagessubredditviewer.app.model.ImageLoaderResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiInterface {
    @GET("r/images/hot.json")
    fun getImages() : Call<ImageLoaderResponse>
}