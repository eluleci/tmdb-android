package com.eluleci.tmdbshowcase.viewmodel.movielist

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieListViewModelFactory @Inject
constructor() : ViewModelProvider.NewInstanceFactory() {

    @Inject
    lateinit var mViewModel: MovieListViewModel

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return mViewModel as T
    }
}
