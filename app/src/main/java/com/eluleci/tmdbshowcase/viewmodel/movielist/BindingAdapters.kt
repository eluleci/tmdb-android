package com.eluleci.tmdbshowcase.viewmodel.movielist

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView

import com.eluleci.tmdbshowcase.service.model.Movie
import com.eluleci.tmdbshowcase.view.adapter.MovieListAdapter

/**
 * Contains the binding adapters that can be used
 * by the layouts related to the MovieListViewModel.
 */

/**
 * Sets the given Movie list to the adapter of given RecyclerView.
 * @param recyclerView to update the adapter of.
 * @param movies that will be set to the adapter.
 */
@BindingAdapter("movieList")
fun setMovieList(recyclerView: RecyclerView, movies: LiveData<List<Movie>>) {
    if (recyclerView.adapter is MovieListAdapter) {
        movies.observe(recyclerView.context as LifecycleOwner, Observer { movies -> (recyclerView.adapter as MovieListAdapter).setMovieList(movies!!) })
    }
}