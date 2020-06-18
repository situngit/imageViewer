package com.situn.imagessubredditviewer.app.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.situn.imagessubredditviewer.R
import com.situn.imagessubredditviewer.app.activity.FullScreenImageActivity
import com.situn.imagessubredditviewer.app.model.ImageLoadModel
import com.situn.imagessubredditviewer.imageloader.DoubleCache
import com.situn.imagessubredditviewer.imageloader.ImageLoader

class ImageLoadAdapter(val imageList: ArrayList<ImageLoadModel>) : RecyclerView.Adapter<ImageLoadAdapter.ViewHolder>(){

    lateinit var context : Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row,parent,false)
        context = parent.context
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return imageList.size;
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val imageValue : ImageLoadModel = imageList[position]

        // Set height and width dynamically
        //   holder.imageMain.setLayoutParams(LinearLayout.LayoutParams(imageValue.thumbnail_height,imageValue.thumbnail_width))

        ImageLoader.setCache(DoubleCache(context))
        ImageLoader.displayImage(imageValue.imageThumb, holder.imageMain)
        ImageLoader.clearCache()

        //Setting image in a full screen
        holder.imageMain.setOnClickListener{
            val intent = Intent(holder.itemView.context, FullScreenImageActivity::class.java)
            intent.putExtra("ImageUrl", imageValue.imageResoure)
            holder.itemView.context.startActivity(intent)
        }
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val imageMain = itemView.findViewById(R.id.iv_row) as ImageView
    }
}