package com.eluleci.tmdbshowcase.repository

import com.eluleci.tmdbshowcase.repository.network.TMDbService

import javax.inject.Singleton

import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Singleton
    @Provides
    internal fun provideMovieRepository(service: TMDbService): MovieRepository {
        return MovieRepositoryImpl(service)
    }
}
