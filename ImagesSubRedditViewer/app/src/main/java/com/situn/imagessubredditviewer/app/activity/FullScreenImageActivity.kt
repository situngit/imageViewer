package com.situn.imagessubredditviewer.app.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.situn.imagessubredditviewer.R
import com.situn.imagessubredditviewer.app.utils.Utility
import com.situn.imagessubredditviewer.imageloader.DoubleCache
import com.situn.imagessubredditviewer.imageloader.ImageLoader

class FullScreenImageActivity : AppCompatActivity() {
    private lateinit var ivImageFull : ImageView;
    private lateinit var ivBack : ImageView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_screen_image)

        findIds()
        setImageFull()
        setListeners()

    }


    //Find Ids
    private fun findIds() {
        ivImageFull = findViewById(R.id.iv_image_full)
        ivBack = findViewById(R.id.iv_back)
    }

    //Set image based on data
    private fun setImageFull() {
        Utility.showProgressDialog(this)
        val imageUrl = intent.getStringExtra("ImageUrl")
        ImageLoader.setCache(DoubleCache(this))
        ImageLoader.displayImage(imageUrl, ivImageFull)
        ImageLoader.clearCache()
        Utility.hideProgressDialog()

    }

    //Set back click
    private fun setListeners() {
        ivBack.setOnClickListener {
            finish()
        }

    }
}