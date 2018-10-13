package com.eluleci.tmdbshowcase.viewmodel

import android.databinding.BindingAdapter
import android.view.View

@BindingAdapter("visibility")
fun setVisibility(view: View, value: Boolean) {
    view.visibility = if (value) View.VISIBLE else View.GONE
}