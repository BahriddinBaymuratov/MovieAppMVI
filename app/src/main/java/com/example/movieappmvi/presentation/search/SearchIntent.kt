package com.example.movieappmvi.presentation.search

sealed class SearchIntent {
    data class OnSearched(val query: String): SearchIntent()
}