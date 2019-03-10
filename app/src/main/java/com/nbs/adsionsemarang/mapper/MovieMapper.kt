package com.nbs.adsionsemarang.mapper

import com.nbs.adsionsemarang.BuildConfig
import com.nbs.adsionsemarang.data.model.MovieItem
import com.nbs.adsionsemarang.presentation.main.model.Movie

fun getMovie(movieItem: MovieItem): Movie =
        with(movieItem){
            Movie(
                title = title?.toUpperCase(),
                poster = getFullPosterUrl(poster),
                id = id,
                url = homePage,
                overview = overview
            )
        }

fun getMovies(listItem: List<MovieItem>?): List<Movie>{
    val list = ArrayList<Movie>()
    for (movieItem in listItem!!){
        list.add(getMovie(movieItem))
    }
    return list
}

fun getFullPosterUrl(posterPath: String?): String
    = BuildConfig.BASE_IMAGE_URL + posterPath