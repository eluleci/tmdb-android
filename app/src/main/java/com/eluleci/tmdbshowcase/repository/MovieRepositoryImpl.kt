package com.eluleci.tmdbshowcase.repository

import android.annotation.SuppressLint

import com.eluleci.tmdbshowcase.model.Movie
import com.eluleci.tmdbshowcase.repository.network.TMDbService
import com.eluleci.tmdbshowcase.repository.network.data.GetMovieListResponse
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

import javax.inject.Inject

/**
 * Main data source for movies.
 */
class MovieRepositoryImpl @Inject
constructor(var service: TMDbService) : MovieRepository {

    @SuppressLint("CheckResult")
    override fun getMovieList(): Single<List<Movie>> = service.getMovieList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMap { response: GetMovieListResponse ->
                Single.create<List<Movie>> { emitter ->
                    emitter.onSuccess(response.results)
                }
            }
}
