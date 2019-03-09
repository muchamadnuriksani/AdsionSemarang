package com.nbs.adsionsemarang.presentation.main

import android.util.Log
import com.nbs.adsionsemarang.domain.main.MainInteractor
import com.nbs.adsionsemarang.presentation.main.model.Movie

class MainPresenter(private val view: MainContract.View): MainContract.Presenter,
    MainInteractor.OnMovieListener{

    val mainInteractor = MainInteractor()

    init {
        mainInteractor.listener = this
    }

    override fun getMovie() {
        mainInteractor.getRemoteMovie()
    }

    override fun onMovieSuccess(list: List<Movie>?) {
        list?.let {
            view.showMovie(it)
        }
    }

    override fun onMovieFailed(message: String) {
        Log.d("Test", message)
        view.showError(message)
    }
}