package com.example.ak7mt_zaluda_radim_movieapp.di

import com.example.ak7mt_zaluda_radim_movieapp.movieList.data.repository.MovieListRepositoryImplementation
import com.example.ak7mt_zaluda_radim_movieapp.movieList.domain.model.repository.MovieListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton

    abstract fun bindMovieListRepository(
        movieListRepositoryImplementation: MovieListRepositoryImplementation
    ): MovieListRepository
}