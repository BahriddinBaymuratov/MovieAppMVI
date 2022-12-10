package com.example.movieappmvi.presentation.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.example.movieappmvi.R
import com.example.movieappmvi.database.MovieDatabase
import com.example.movieappmvi.databinding.FragmentFavoriteBinding
import com.example.movieappmvi.presentation.movie_list.MovieAdapter
import com.example.movieappmvi.repository.LocalRepository
import com.example.movieappmvi.util.toResultMovie
import kotlinx.coroutines.launch

class FavoriteFragment: Fragment(R.layout.fragment_favorite) {
    private lateinit var viewModel: FavoriteViewModel
    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!
    private val movieAdapter by lazy { MovieAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFavoriteBinding.bind(view)
        val dao = MovieDatabase(requireContext()).dao
        val repository = LocalRepository(dao)
        val factory = FavoriteViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory)[FavoriteViewModel::class.java]
        initViews()
    }

    private fun initViews() {
        setupRv()
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.channel.send(FavoriteIntent.OnFragmentLaunched)
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.state.collect { state ->
                when(state) {
                    is FavoriteState.Loading -> {
                        binding.progressBar.isVisible = true
                    }
                    is FavoriteState.Success -> {
                        binding.progressBar.isVisible = false
                        movieAdapter.submitList(state.movieEntities.map { it.toResultMovie() })
                    }
                }
            }
        }
    }

    private fun setupRv() {
        binding.recyclerView.apply {
            adapter = movieAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            val snapHelper = PagerSnapHelper()
            snapHelper.attachToRecyclerView(this)
        }
        movieAdapter.onClick = {
            val bundle = bundleOf("movie" to it, "isSaved" to true)
            findNavController().navigate(R.id.action_mainFragment_to_detailFragment, bundle)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}