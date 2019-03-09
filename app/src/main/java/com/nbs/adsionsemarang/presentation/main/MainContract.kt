package com.nbs.adsionsemarang.presentation.main

import com.nbs.adsionsemarang.presentation.main.model.Movie

interface MainContract {
    interface View{
        fun showMovie(list: List<Movie>)

        fun showError(message: String)
    }

    interface Presenter{
        fun getMovie()
    }
}