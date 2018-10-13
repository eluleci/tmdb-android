package com.eluleci.tmdbshowcase.viewmodel

import android.databinding.BindingAdapter
import android.view.View
import android.widget.ImageView
import com.eluleci.tmdbshowcase.BuildConfig
import com.squareup.picasso.Picasso

@BindingAdapter("visibility")
fun setVisibility(view: View, value: Boolean) {
    view.visibility = if (value) View.VISIBLE else View.GONE
}

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, imageUrl: String?) {
    if (imageUrl != null && !imageUrl.isEmpty()) {
        Picasso.get().load(BuildConfig.IMAGE_URL + imageUrl).into(view)
    }
}
