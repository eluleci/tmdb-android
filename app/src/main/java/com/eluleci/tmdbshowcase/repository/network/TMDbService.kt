package com.eluleci.tmdbshowcase.repository.network

import com.eluleci.tmdbshowcase.repository.network.data.GetMovieListResponse
import io.reactivex.Single

import retrofit2.http.GET

/**
 * Retrofit service to consume The Movie Database API.
 */
interface TMDbService {

    @GET("movie/now_playing")
    fun getMovieList(): Single<GetMovieListResponse>
}
