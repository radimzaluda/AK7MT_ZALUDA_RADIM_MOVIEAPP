package com.example.ak7mt_zaluda_radim_movieapp.movieList.domain.model.repository

import com.ahmedapps.moviesapp.movieList.util.Resource
import com.example.ak7mt_zaluda_radim_movieapp.movieList.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieListRepository {
    suspend fun getMovieList(
        forceFetchFromRemote: Boolean,
        category: String,
        page: Int
    ):Flow<Resource<List<Movie>>>

    suspend fun getMovie(id: Int): Flow<Resource<Movie>>

}