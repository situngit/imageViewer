package com.situn.imagessubredditviewer.app.activity

import android.graphics.Movie
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.situn.imagessubredditviewer.R
import com.situn.imagessubredditviewer.app.adapter.ImageLoadAdapter
import com.situn.imagessubredditviewer.app.model.ImageLoadModel
import com.situn.imagessubredditviewer.app.model.ImageLoaderResponse
import com.situn.imagessubredditviewer.app.services.ApiClient.client
import com.situn.imagessubredditviewer.app.services.ApiInterface
import com.situn.imagessubredditviewer.app.utils.Utility
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DashBoardActivity : AppCompatActivity() {
    private lateinit var rvImage : RecyclerView;
    // private lateinit var adapter : ArrayList<ImageLoadAdapter>;
    var images = ArrayList<ImageLoadModel>()
    lateinit var adapter : ImageLoadAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)

        findIds();
        initRecycler();
        listeners();
    }

    //Find Ids
    private fun findIds() {

    }

    //Initialize recyclerview
    private fun initRecycler() {
        rvImage = findViewById(R.id.rv_image) as RecyclerView
        rvImage.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        images = ArrayList<ImageLoadModel>()
        adapter = ImageLoadAdapter(images)
        rvImage.adapter = adapter
    }

    //Click listeners
    private fun listeners() {
        fetchImageList()
    }

    private fun fetchImageList() {

        Utility.showProgressDialog(this)
        val apiService =
            client!!.create(ApiInterface::class.java)

        val call: Call<ImageLoaderResponse> = apiService.getImages()
        call.enqueue(object : Callback<ImageLoaderResponse> {
            override fun onResponse(call: Call<ImageLoaderResponse>, response: Response<ImageLoaderResponse>) {

                Utility.hideProgressDialog()
                for (i in 1 ..(response.body()?.getData()?.children!!.size - 1)) {
                    images.add(
                        ImageLoadModel(
                            response.body()?.getData()?.children?.get(i)?.data?.url.toString(),
                            response.body()?.getData()?.children?.get(i)?.data?.thumbnail.toString(),
                            response.body()?.getData()?.children?.get(i)?.data?.thumbnailHeight!!,
                            response.body()?.getData()?.children?.get(i)?.data?.thumbnailWidth!!
                        )
                    )
                }

                adapter.notifyDataSetChanged()

                }

                override fun onFailure(call: Call<ImageLoaderResponse>, t: Throwable) {
                    // Log error here since request failed
                    Utility.hideProgressDialog()
                }
            })
        }
    }