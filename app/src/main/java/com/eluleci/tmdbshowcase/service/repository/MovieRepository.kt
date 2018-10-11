package com.eluleci.tmdbshowcase.service.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData

import com.eluleci.tmdbshowcase.service.model.Movie
import com.eluleci.tmdbshowcase.service.repository.network.requestmodels.GetMovieListResponse
import com.eluleci.tmdbshowcase.service.repository.network.TMDbService

import javax.inject.Inject

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Main data source for movies.
 */
class MovieRepository @Inject
constructor(var service: TMDbService) {

    /**
     * LiveData that contains a List<Movie>. Returns the LiveData
     * and starts to fetch the Movie list from the service when accessed.
     */
    val movieList: LiveData<List<Movie>>
        get() {
            val data = MutableLiveData<List<Movie>>()

            service.movieList.enqueue(object : Callback<GetMovieListResponse> {
                override fun onResponse(call: Call<GetMovieListResponse>, response: Response<GetMovieListResponse>) {
                    data.value = response.body()!!.results
                }

                override fun onFailure(call: Call<GetMovieListResponse>, t: Throwable) {

                }
            })

            return data
        }
}
