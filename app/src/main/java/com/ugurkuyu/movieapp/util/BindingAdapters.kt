package com.ugurkuyu.movieapp.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import com.ugurkuyu.movieapp.R

object BindingAdapters {

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun loadImage(view: ImageView, url: String?) {
        Picasso.get().load(Constants.BASE_IMAGE_URL + url).fit().error(R.drawable.ic_person).into(view)
    }
}