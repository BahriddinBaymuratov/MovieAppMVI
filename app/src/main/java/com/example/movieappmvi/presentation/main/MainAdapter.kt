package com.example.movieappmvi.presentation.main

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.movieappmvi.presentation.favorite.FavoriteFragment
import com.example.movieappmvi.presentation.movie_list.MovieFragment
import com.example.movieappmvi.presentation.search.SearchFragment

class MainAdapter(
    fragment: Fragment,
) : FragmentStateAdapter(fragment){
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> MovieFragment()
            1 -> SearchFragment()
            2 -> FavoriteFragment()
            else -> Fragment()
        }
    }
}