package com.eluleci.tmdbshowcase.viewmodel.movielist

import com.eluleci.tmdbshowcase.model.Movie

class MovieListRowViewModel {
    lateinit var title: String

    fun bind(movie: Movie) {
        title = movie.title
    }
}
