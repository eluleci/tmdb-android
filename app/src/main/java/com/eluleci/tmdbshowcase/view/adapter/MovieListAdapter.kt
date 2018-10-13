package com.eluleci.tmdbshowcase.view.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.eluleci.tmdbshowcase.R
import com.eluleci.tmdbshowcase.databinding.ListRowMovieBinding
import com.eluleci.tmdbshowcase.model.Movie
import com.eluleci.tmdbshowcase.viewmodel.movielist.MovieListRowViewModel

/**
 * RecyclerView adapter for Movie list that uses R.layout.list_row_movie in rows.
 */
class MovieListAdapter : RecyclerView.Adapter<MovieListAdapter.ViewHolder>() {

    private lateinit var movieList: List<Movie>

    fun setMovieList(list: List<Movie>) {
        movieList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListAdapter.ViewHolder {

        val binding: ListRowMovieBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.list_row_movie,
                parent,
                false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieListAdapter.ViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int {
        if (::movieList.isInitialized) {
            return movieList.size
        }
        return 0
    }

    inner class ViewHolder(private val binding: ListRowMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        private val viewModel = MovieListRowViewModel()

        fun bind(movie: Movie) {
            viewModel.bind(movie)
            binding.viewModel = viewModel
        }

    }
}
