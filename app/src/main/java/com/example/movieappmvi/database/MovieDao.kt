package com.example.movieappmvi.database

import androidx.room.*
import com.example.movieappmvi.model.MovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovie(movieEntity: MovieEntity)

    @Delete
    suspend fun deleteMovie(movieEntity: MovieEntity)

    @Query("SELECT * FROM Movies ORDER BY id DESC")
    fun getAllMovies(): Flow<List<MovieEntity>>
}