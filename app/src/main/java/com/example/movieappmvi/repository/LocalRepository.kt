package com.example.movieappmvi.repository

import com.example.movieappmvi.database.MovieDao
import com.example.movieappmvi.model.MovieEntity

class LocalRepository(
    private val dao: MovieDao
) {
    suspend fun saveMovie(movieEntity: MovieEntity) = dao.saveMovie(movieEntity)
    fun getAllMovies() = dao.getAllMovies()
    suspend fun deleteMovie(movieEntity: MovieEntity) = dao.deleteMovie(movieEntity)
}