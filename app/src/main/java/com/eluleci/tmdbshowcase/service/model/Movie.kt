package com.eluleci.tmdbshowcase.service.model

import com.google.gson.annotations.SerializedName

data class Movie(
        @SerializedName("adult") val adult: Boolean,
        @SerializedName("genre_ids") val genreIds: IntArray,
        @SerializedName("id") val id: String,
        @SerializedName("original_language") val originalLanguage: String,
        @SerializedName("original_title") val originalTitle: String,
        @SerializedName("overview") val overview: String,
        @SerializedName("popularity") val popularity: Float,
        @SerializedName("poster_path") val posterPath: String,
        @SerializedName("release_date") val releaseDate: String,
        @SerializedName("title") val title: String,
        @SerializedName("video") val video: Boolean,
        @SerializedName("vote_count") val voteCount: Int,
        @SerializedName("vote_average") val voteAverage: Float
)
