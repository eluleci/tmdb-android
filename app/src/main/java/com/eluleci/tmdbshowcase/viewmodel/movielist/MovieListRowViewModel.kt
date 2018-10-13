package com.eluleci.tmdbshowcase.viewmodel.movielist

import com.eluleci.tmdbshowcase.model.Movie

class MovieListRowViewModel {
    lateinit var title: String
    lateinit var posterPath: String
    lateinit var overview: String
    lateinit var voteAverage: String

    fun bind(movie: Movie) {
        posterPath = movie.posterPath
        overview = movie.overview
        title = movie.title
        voteAverage = movie.voteAverage.toString()
    }
}
