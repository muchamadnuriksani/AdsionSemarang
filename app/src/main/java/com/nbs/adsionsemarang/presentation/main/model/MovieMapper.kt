package com.nbs.adsionsemarang.presentation.main.model

import com.nbs.adsionsemarang.data.model.MovieItem

fun getMovie(movieItem: MovieItem): Movie =
        with(movieItem){
            Movie(title = title, poster = poster)
        }

fun getMovies(listItem: List<MovieItem>?): List<Movie>{
    val list = ArrayList<Movie>()
    listItem?.let {
        for (movieItem in it){
            list.add(getMovie(movieItem))
        }
    }
    return list
}