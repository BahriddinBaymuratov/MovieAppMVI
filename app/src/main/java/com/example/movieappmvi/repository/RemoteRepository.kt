package com.example.movieappmvi.repository

import com.example.movieappmvi.network.ApiService

class RemoteRepository(
    private val apiService: ApiService
) {
    suspend fun getMovies() = apiService.getMovies()
    suspend fun searchMovie(query: String) = apiService.searchMovie(query = query)
}