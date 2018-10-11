package com.eluleci.tmdbshowcase.di

import com.eluleci.tmdbshowcase.view.ui.MovieListActivity
import com.eluleci.tmdbshowcase.viewmodel.movielist.MovieListModule

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class ActivityBindingModule {

    /**
     * MovieListActivity is only dependant on MovieListModule.
     */
    @ContributesAndroidInjector(modules = [MovieListModule::class])
    internal abstract fun trackListActivity(): MovieListActivity
}
