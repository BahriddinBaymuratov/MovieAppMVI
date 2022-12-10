package com.example.movieappmvi.network

import com.example.movieappmvi.model.Movie
import com.example.movieappmvi.util.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("3/movie/popular")
    suspend fun getMovies(
        @Query("api_key") apiKey: String = Constants.API_KEY,
        @Query("page") page: Int = 1
    ): Response<Movie>

    @GET("3/search/movie")
    suspend fun searchMovie(
        @Query("api_key") api_key: String = Constants.API_KEY,
        @Query("query") query: String,
        @Query("page") page: Int = 1
    ): Response<Movie>
}