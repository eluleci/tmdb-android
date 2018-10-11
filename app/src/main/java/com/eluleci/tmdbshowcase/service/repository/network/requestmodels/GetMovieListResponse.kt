package com.eluleci.tmdbshowcase.service.repository.network.requestmodels

import com.eluleci.tmdbshowcase.service.model.Movie

data class GetMovieListResponse(val results: List<Movie>)
