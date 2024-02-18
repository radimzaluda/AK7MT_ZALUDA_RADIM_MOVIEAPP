package com.example.ak7mt_zaluda_radim_movieapp.movieList.domain.model

import androidx.room.Entity


@Entity
data class Movie(
    val adult: Boolean,
    val backdrop_path: String,
    val genre_ids: String,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int,

    val category: String,
)
