package com.nbs.adsionsemarang.presentation.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.nbs.adsionsemarang.R
import com.nbs.adsionsemarang.presentation.main.model.Movie
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieAdapter(val movieItems: ArrayList<Movie>,
                   private val onMovieItemCallback:
                   OnMovieItemCallback):
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int)
        = ViewHolder(LayoutInflater.from(p0.context)
        .inflate(R.layout.item_movie, p0, false),
        onMovieItemCallback)

    override fun getItemCount() = movieItems.size

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bind(movieItems[p1])
    }

    inner class ViewHolder(itemView: View,
                           private val onMovieItemCallback:
                           OnMovieItemCallback):
        RecyclerView.ViewHolder(itemView){

        fun bind(movie: Movie){
            Glide.with(itemView.context)
                .load(movie.poster)
                .into(itemView.imgMovie)

            itemView.imgMovie.setOnClickListener {
                onMovieItemCallback.onMovieItemClicked(movie)
            }
        }
    }

    interface OnMovieItemCallback{
        fun onMovieItemClicked(movie: Movie)
    }
}