package com.example.movieappmvi.presentation.favorite

sealed class FavoriteIntent {
    object OnFragmentLaunched: FavoriteIntent()
}