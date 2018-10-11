package com.eluleci.tmdbshowcase.service.repository.network

import com.eluleci.tmdbshowcase.service.repository.network.requestmodels.GetMovieListResponse

import retrofit2.Call
import retrofit2.http.GET

/**
 * Retrofit service to consume The Movie Database API.
 */
interface TMDbService {

    @get:GET("movie/now_playing")
    val movieList: Call<GetMovieListResponse>
}
