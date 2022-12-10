package com.example.movieappmvi.presentation.detail

import com.example.movieappmvi.model.MovieEntity

sealed class DetailIntent {
    data class OnSaveClicked(val movieEntity: MovieEntity): DetailIntent()
    data class OnDeleteClicked(val movieEntity: MovieEntity): DetailIntent()
}