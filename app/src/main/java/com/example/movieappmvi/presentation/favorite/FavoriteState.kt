package com.example.movieappmvi.presentation.favorite

import com.example.movieappmvi.model.MovieEntity

sealed class FavoriteState {
    object Loading: FavoriteState()
    data class Success(val movieEntities: List<MovieEntity>): FavoriteState()
}