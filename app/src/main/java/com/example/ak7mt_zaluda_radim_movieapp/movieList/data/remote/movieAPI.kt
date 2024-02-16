package com.example.ak7mt_zaluda_radim_movieapp.movieList.data.remote

import com.example.ak7mt_zaluda_radim_movieapp.movieList.data.remote.respond.MovieListDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface movieAPI {
    @GET("movie/{category}")
    suspend fun getMoviesList(
        @Path("category") category: String,
        @Query("page") page: Int,
        @Query("api_key") apiKey: String = API_KEY
    ): MovieListDTO

    companion object {
        const val BASE_URL = "https://api.themoviedb.org/3/"
        const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500"
        const val API_KEY = "829f9eb292a2886997a7ed00b75c44e1"
    }
}