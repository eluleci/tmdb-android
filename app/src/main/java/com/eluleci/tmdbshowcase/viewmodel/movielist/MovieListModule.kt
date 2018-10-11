package com.eluleci.tmdbshowcase.viewmodel.movielist

import javax.inject.Singleton

import dagger.Module

@Module
abstract class MovieListModule {

    @Singleton
    internal abstract fun provideTrackListViewModelFactory(): MovieListViewModelFactory
}
