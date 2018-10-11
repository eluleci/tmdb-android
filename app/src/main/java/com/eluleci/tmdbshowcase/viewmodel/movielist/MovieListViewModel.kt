package com.eluleci.tmdbshowcase.viewmodel.movielist

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData

import com.eluleci.tmdbshowcase.service.model.Movie
import com.eluleci.tmdbshowcase.service.repository.MovieRepository

import javax.inject.Inject

class MovieListViewModel @Inject
constructor(application: Application, movieRepository: MovieRepository) : AndroidViewModel(application) {

    /**
     * Movie list is a LiveData that is retrieved from MovieRepository on initialisation.
     */
    val movieList: LiveData<List<Movie>> = movieRepository.movieList
}