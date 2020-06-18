package com.situn.imagessubredditviewer.app.utils

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import android.view.WindowManager
import com.situn.imagessubredditviewer.R

object Utility {
    private var _progressDialog: Dialog? = null

    fun showProgressDialog(context : Context) {
        _progressDialog = Dialog(context)
        _progressDialog!!.getWindow()?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        _progressDialog!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
        _progressDialog!!.getWindow()?.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
        _progressDialog!!.setContentView(R.layout.network_progress_dialog)
        _progressDialog!!.setCancelable(false)
        _progressDialog!!.show()
    }

    fun hideProgressDialog() {
        if (_progressDialog != null) {
            _progressDialog!!.dismiss()
        }
    }


}