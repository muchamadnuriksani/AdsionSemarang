package com.nbs.adsionsemarang.presentation.detail

import com.nbs.adsionsemarang.presentation.main.model.Movie

interface DetailMovieContract {
    interface View{
        fun showDetailMovie(movie: Movie)

        fun showError(message: String)
    }

    interface Presenter{
        fun getDetailMovie(id: String)
    }
}