package com.eluleci.tmdbshowcase.repository

import com.eluleci.tmdbshowcase.model.Movie
import io.reactivex.Single

interface MovieRepository {
    fun getMovieList(): Single<List<Movie>>
}