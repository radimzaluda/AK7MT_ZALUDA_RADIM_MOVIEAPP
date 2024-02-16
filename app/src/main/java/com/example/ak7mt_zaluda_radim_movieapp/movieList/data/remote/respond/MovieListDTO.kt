package com.example.ak7mt_zaluda_radim_movieapp.movieList.data.remote.respond

data class MovieListDTO(
    val page: Int,
    val results: List<MovieDTO>,
    val total_pages: Int,
    val total_results: Int
)