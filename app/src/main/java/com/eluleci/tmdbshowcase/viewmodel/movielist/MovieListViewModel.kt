package com.eluleci.tmdbshowcase.viewmodel.movielist

import android.annotation.SuppressLint
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

import com.eluleci.tmdbshowcase.model.Movie
import com.eluleci.tmdbshowcase.repository.MovieRepository

class MovieListViewModel
constructor(val movieRepository: MovieRepository) : ViewModel() {

    /**
     * Movie list is a LiveData that is retrieved from MovieRepositoryImpl on initialisation.
     */
    var movieList: MutableLiveData<List<Movie>> = MutableLiveData()
    var isPending: MutableLiveData<Boolean> = MutableLiveData()
    var hasError: MutableLiveData<Boolean> = MutableLiveData()

    /**
     * Gets movie list from the repository.
     */
    @SuppressLint("CheckResult")
    fun getMovieList() {

        isPending.value = true

        movieRepository.getMovieList().subscribe({ list ->
            isPending.value = false
            movieList.value = list
        }, {
            isPending.value = false
            hasError.value = true
        })
    }
}