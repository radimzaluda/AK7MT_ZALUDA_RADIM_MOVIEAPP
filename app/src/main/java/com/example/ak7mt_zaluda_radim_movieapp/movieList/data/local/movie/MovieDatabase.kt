package com.example.ak7mt_zaluda_radim_movieapp.movieList.data.local.movie

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    entities = [MovieEntity::class],
    version = 1
)
abstract class MovieDatabase : RoomDatabase() {
    abstract val MovieDao:MovieDao
}