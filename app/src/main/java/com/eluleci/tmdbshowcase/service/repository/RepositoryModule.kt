package com.eluleci.tmdbshowcase.service.repository

import com.eluleci.tmdbshowcase.service.repository.network.TMDbService

import javax.inject.Singleton

import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Singleton
    @Provides
    internal fun provideMovieRepository(mTMDbService: TMDbService): MovieRepository {
        return MovieRepository(mTMDbService)
    }
}
