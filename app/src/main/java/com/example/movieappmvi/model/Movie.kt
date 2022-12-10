package com.example.movieappmvi.model

data class Movie(
    val page: Int,
    val results: List<ResultMovie>,
    val total_pages: Int,
    val total_results: Int
)