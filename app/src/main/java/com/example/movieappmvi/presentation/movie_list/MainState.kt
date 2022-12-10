package com.example.movieappmvi.presentation.movie_list

import com.example.movieappmvi.model.ResultMovie

sealed class MainState {
    object Init: MainState()
    object Loading: MainState()
    data class Error(val error: String): MainState()
    data class Success(val movies: List<ResultMovie>): MainState()
}