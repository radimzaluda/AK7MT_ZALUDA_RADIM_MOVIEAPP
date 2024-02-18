package com.example.ak7mt_zaluda_radim_movieapp.movieList.data.repository

import com.example.ak7mt_zaluda_radim_movieapp.movieList.util.Resource
import com.example.ak7mt_zaluda_radim_movieapp.movieList.data.local.movie.MovieDatabase
import com.example.ak7mt_zaluda_radim_movieapp.movieList.data.mappers.toMovie
import com.example.ak7mt_zaluda_radim_movieapp.movieList.data.mappers.toMovieEntity
import com.example.ak7mt_zaluda_radim_movieapp.movieList.data.remote.movieAPI
import com.example.ak7mt_zaluda_radim_movieapp.movieList.domain.model.Movie
import com.example.ak7mt_zaluda_radim_movieapp.movieList.domain.model.repository.MovieListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MovieListRepositoryImplementation @Inject constructor(
    private val movieAPI: movieAPI,
    private val movieDatabase: MovieDatabase
) : MovieListRepository {

    override suspend fun getMovieList(
        forceFetchFromRemote: Boolean,
        category: String,
        page: Int
    ): Flow<Resource<List<Movie>>> {
        return flow {

            emit(Resource.Loading(true))

            val localMovieList = movieDatabase.MovieDao.getMovieListByCategory(category)
//

            val shouldLoadLocalMovie = localMovieList.isNotEmpty() && !forceFetchFromRemote

            if (shouldLoadLocalMovie) {
                emit(
                    Resource.Success(
                    data = localMovieList.map { movieEntity ->
                        movieEntity.toMovie(category)
                    }
                ))

                emit(Resource.Loading(false))
                return@flow
            }

            val movieListFromApi = try {
                movieAPI.getMoviesList(category, page)
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error(message = "Error"))
                return@flow
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error(message = "Error"))
                return@flow
            } catch (e: Exception) {
                e.printStackTrace()
                emit(Resource.Error(message = "Error"))
                return@flow
            }

            val movieEntities = movieListFromApi.results.let {
                it.map { movieDto ->
                    movieDto.toMovieEntity(category)
                }
            }
            movieDatabase.MovieDao.upsertMovieList(movieEntities)


            emit(
                Resource.Success(
                movieEntities.map { it.toMovie(category) }
            ))
            emit(Resource.Loading(false))

        }
    }

    override suspend fun getMovie(id: Int): Flow<Resource<Movie>> {
        return flow {

            emit(Resource.Loading(true))

            val movieEntity = movieDatabase.MovieDao.getMovieById(id)


            if (movieEntity != null) {
                emit(
                    Resource.Success(movieEntity.toMovie(movieEntity.category))
                )

                emit(Resource.Loading(false))
                return@flow
            }

            emit(Resource.Error("Error no such movie"))

            emit(Resource.Loading(false))


        }
    }
}


