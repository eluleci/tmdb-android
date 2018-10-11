package com.eluleci.tmdbshowcase.view.ui

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.eluleci.tmdbshowcase.R
import com.eluleci.tmdbshowcase.databinding.ActivityMovieListBinding
import com.eluleci.tmdbshowcase.view.adapter.MovieListAdapter
import com.eluleci.tmdbshowcase.viewmodel.movielist.MovieListViewModel
import com.eluleci.tmdbshowcase.viewmodel.movielist.MovieListViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

/**
 * Shows movie list in a RecyclerView with a vertical layout.
 */
class MovieListActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var mMovieListViewModelFactory: MovieListViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // create binding for the layout
        val binding: ActivityMovieListBinding = DataBindingUtil
                .setContentView(this, R.layout.activity_movie_list);

        // create view model from the factory
        val vm = ViewModelProviders
                .of(this@MovieListActivity, mMovieListViewModelFactory)
                .get(MovieListViewModel::class.java)

        // set attributes of binding
        binding.apply {
            setLifecycleOwner(this@MovieListActivity)
            recyclerView.adapter = MovieListAdapter()
            viewModel = vm
        }
    }
}
