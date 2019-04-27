package com.example.androidlatihan16.ui.util

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide

class DataBinder {
    companion object {
        @JvmStatic
            @BindingAdapter("app:imageUrl")
            fun setImageUrl(imView : ImageView, url : String){
                val context = imView.context
            Glide.with(context).load(url).into((imView))
        }
    }
}