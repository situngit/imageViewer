package com.situn.imagessubredditviewer.imageloader

import android.content.Context
import android.graphics.Bitmap

class DoubleCache(context: Context) : ImageCache {

    private val memCache = MemoryCache()

    override fun get(url: String): Bitmap? {
        return memCache.get(url)
    }

    override fun put(url: String, bitmap: Bitmap) {
        memCache.put(url, bitmap)
    }

    override fun clear() {
        memCache.clear()
    }
}