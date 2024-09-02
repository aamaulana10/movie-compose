package com.aamaulana10.moviecompose.feature.home.core.domain.model

data class MovieVideosResponse(
    val id: Int,
    val results: List<MovieVideosModel>
)

data class MovieVideosModel(
    val id: String,
    val title: String,
    val adult: Boolean,
    val backdrop_path: String,
    val genre_ids: List<Int>,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
)