package com.eluleci.tmdbshowcase.viewmodel.movielist

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.eluleci.tmdbshowcase.repository.MovieRepository

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieListViewModelFactory @Inject
constructor(val movieRepository: MovieRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieListViewModel(movieRepository) as T
    }
}
